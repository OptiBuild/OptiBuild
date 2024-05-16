package com.optibuild.website.Service;

import com.optibuild.website.model.components.CPU;
import com.optibuild.website.repository.CPURepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class CPUService {
    private static final Logger logger = LoggerFactory.getLogger(HardDriveService.class);

    private final CPURepository cpuRepository;
    @Autowired
    public CPUService(CPURepository cpuRepository) {
        this.cpuRepository = cpuRepository;
    }

    public CPU cpuModel(List<String> cpuList) {
        logger.info("Start finding for cpu model...");

        CPU cpu = cpuRepository.findByBrandAndModel("Intel", "Core i5-14600K");
        if (cpuList.size() == 1) {
            logger.info("cpu list size is 1.");
            logger.info("Find cpu: brand: Intel，model: {}", cpuList.get(0));
            cpu = cpuRepository.findByBrandAndModel("Intel", cpuList.get(0));

        } else {
            logger.info("cpu list size: {}", cpuList.size());
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

        if(cpu==null){
            logger.error("No cpu found.");
        } else {
            logger.info("cpu model: {}", cpu.getModel());
            logger.info("cpu socket: {}", cpu.getSocketType());
        }

        return cpu;
    }
}
