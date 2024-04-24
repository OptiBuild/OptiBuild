package com.optibuild.website.Service;

import com.optibuild.website.model.components.CPU;
import com.optibuild.website.repository.CPURepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.info("进入了 cpuModel 方法");

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
        if(cpu != null) {
            logger.info("找到了得分更高的 CPU 模型：{}，得分：{}", cpu.getModel(), cpu.getScore());
        } else {
            logger.info("未找到 CPU 模型：{}", cpu.getModel());
        }

        return cpu;
    }
}
