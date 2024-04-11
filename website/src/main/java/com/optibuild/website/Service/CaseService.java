package com.optibuild.website.Service;

import com.optibuild.website.model.components.*;
import com.optibuild.website.repository.CaseRepository;
import com.optibuild.website.repository.FormFactorCompatibilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CaseService {
    private final CaseRepository caseRepository;
    private final FormFactorCompatibilityRepository formFactorCompatibilityRepository;
    @Autowired
    public CaseService (CaseRepository caseRepository, FormFactorCompatibilityRepository formFactorCompatibilityRepository) {
        this.caseRepository = caseRepository;
        this.formFactorCompatibilityRepository = formFactorCompatibilityRepository;
    }

    public Case getCase (GPU gpu, Motherboard motherboard, PowerSupply powerSupply, CPUCooler cpuCooler) {
        String formFactor = motherboard!=null ? motherboard.getFormFactor() : null;
        int gpuLength = gpu!=null ? gpu.getLength() : 0;
        int psuLength = powerSupply!=null ? powerSupply.getMaxPSULength() : 0;
        int cpuCoolerHeight = cpuCooler!=null ? cpuCooler.getHeight() : 0;
        List<Case> caseList;
        caseList = caseRepository.findByMaxGPULengthGreaterThanAndMaxCPUCoolerHeightGreaterThanAndMaxPSULengthGreaterThan(gpuLength-1, cpuCoolerHeight-1, psuLength-1);

        // Further filter the cases based on motherboard compatibility
        if (motherboard != null) {
            FormFactorCompatibility formFactorCompatibility = formFactorCompatibilityRepository.findByFormFactorType(formFactor);
            Set<Case> compatibleCaseSet = formFactorCompatibility.getCompatibleCases();
            List<Case> compatibleCases = new ArrayList<>();
            for (Case aCase : caseList) {
                if (compatibleCaseSet.contains(aCase)) {
                    compatibleCases.add(aCase);
                }
            }
            caseList = compatibleCases;
        }

        Case mostAffordableCase = null;
        for (Case c : caseList) {
            if (mostAffordableCase == null || c.getPrice() < mostAffordableCase.getPrice()) {
                mostAffordableCase = c;
            }
        }

        return mostAffordableCase;
    }
}
