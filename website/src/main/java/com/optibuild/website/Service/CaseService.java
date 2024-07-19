package com.optibuild.website.Service;

import com.optibuild.website.model.components.*;
import com.optibuild.website.repository.CaseRepository;
import com.optibuild.website.repository.FormFactorCompatibilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class CaseService {
    private static final Logger logger = LoggerFactory.getLogger(CaseService.class);
    private final CaseRepository caseRepository;
    private final FormFactorCompatibilityRepository formFactorCompatibilityRepository;
    @Autowired
    public CaseService (CaseRepository caseRepository, FormFactorCompatibilityRepository formFactorCompatibilityRepository) {
        this.caseRepository = caseRepository;
        this.formFactorCompatibilityRepository = formFactorCompatibilityRepository;
    }

    public Case getCase (List<Case> caseList){
        Case mostAffordableCase = null;
        for (Case c : caseList) {
            if (mostAffordableCase == null || c.getPrice() < mostAffordableCase.getPrice()) {
                mostAffordableCase = c;
            }
        }

        if (mostAffordableCase != null) {
            logger.info("Most affordable case found: {} with price: {}", mostAffordableCase.getModel(), mostAffordableCase.getPrice());
        } else {
            logger.warn("No compatible case found.");
        }

        return mostAffordableCase;
    }

    public List<Case> getCaseList (GPU gpu, Motherboard motherboard, PowerSupply powerSupply, CPUCooler cpuCooler) {
        String formFactor = motherboard!=null ? motherboard.getFormFactor() : null;
        int gpuLength = gpu!=null ? gpu.getLength() : 0;
        int psuLength = powerSupply!=null ? powerSupply.getMaxPSULength() : 0;
        int cpuCoolerHeight = cpuCooler!=null ? cpuCooler.getHeight() : 0;
        logger.info("Received parameters - GPU length: {}, PSU length: {}, CPU Cooler height: {}, Motherboard form factor: {}",
                gpuLength, psuLength, cpuCoolerHeight, formFactor);
        List<Case> caseList;
        caseList = caseRepository.findByMaxGPULengthGreaterThanAndMaxCPUCoolerHeightGreaterThanAndMaxPSULengthGreaterThan(gpuLength-1, cpuCoolerHeight-1, psuLength-1);

        logger.info("Initial case list size: {}", caseList.size());

        if (motherboard != null) {
            FormFactorCompatibility formFactorCompatibility = formFactorCompatibilityRepository.findByFormFactorType(formFactor);
            List<Case> compatibleCases = new ArrayList<>();
            if (formFactorCompatibility != null) {
                Set<Case> compatibleCaseSet = formFactorCompatibility.getCompatibleCases();
                if(compatibleCaseSet.isEmpty()){
                    logger.error("No compatible case found for the given form factor: {}", formFactor);
                }
                for (Case aCase : caseList) {
                    if (compatibleCaseSet.contains(aCase)) {
                        compatibleCases.add(aCase);
                    }
                }
                caseList = compatibleCases;
                logger.info("Filtered case list size after form factor compatibility check: {}", caseList.size());
            } else {
                logger.warn("No form factor compatibility found for form factor: {}", formFactor);
                return null;  // or handle appropriately
            }
        }
        return caseList;


    }

}
