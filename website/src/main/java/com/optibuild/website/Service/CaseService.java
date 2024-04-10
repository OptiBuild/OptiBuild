package com.optibuild.website.Service;

import com.optibuild.website.model.components.*;
import com.optibuild.website.repository.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseService {
    private final CaseRepository caseRepository;
    @Autowired
    public CaseService (CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    public Case getCase (GPU gpu, Motherboard motherboard, PowerSupply powerSupply, CPUCooler cpuCooler) {
        String formFactor = motherboard!=null ? motherboard.getFormFactor() : null;
        int gpuLength = gpu!=null ? gpu.getLength() : 0;
        int psuLength = powerSupply!=null ? powerSupply.getMaxPSULength() : 0;
        int cpuCoolerHeight = cpuCooler!=null ? cpuCooler.getHeight() : 0;
        List<Case> caseList;
        if (formFactor == null) {
            caseList = caseRepository.findByMaxGPULengthGreaterThanAndMaxCPUCoolerHeightGreaterThanAndMaxPSULengthGreaterThan(gpuLength-1, cpuCoolerHeight-1, psuLength-1);
        } else {
            caseList = caseRepository.findByMaxGPULengthGreaterThanAndMaxCPUCoolerHeightGreaterThanAndMaxPSULengthGreaterThanAndMotherboardFormFactorCompatibility(gpuLength-1, cpuCoolerHeight-1, psuLength-1, formFactor);
        }
        return caseList.get(0);
    }
}
