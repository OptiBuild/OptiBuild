package com.optibuild.website.Service;

import com.optibuild.website.model.components.CPU;
import com.optibuild.website.repository.CPURepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CPUService {
    private final CPURepository cpuRepository;
    @Autowired
    public CPUService(CPURepository cpuRepository) {
        this.cpuRepository = cpuRepository;
    }

    public CPU cpuModel(List<String> cpuList) {
        CPU cpu = cpuRepository.findByBrandAndModel("Intel", "Core i5-14600K");
        if (cpuList.size() == 1) {
            cpu = cpuRepository.findByBrandAndModel("Intel", cpuList.get(0));
        } else {
            // find the cpu with the highest score
            int score = cpu.getScore();
            for(String model : cpuList) {
                CPU tempCPU = cpuRepository.findByModel(model);
                if(tempCPU != null && tempCPU.getScore() > score) {
                    score = tempCPU.getScore();
                    cpu = tempCPU;
                }

            }
        }
        return cpu;
    }
}
