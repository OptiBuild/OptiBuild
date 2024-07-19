package com.optibuild.website.Service;

import com.optibuild.website.model.components.GPU;
import com.optibuild.website.repository.GPURepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GPUService {
    private final GPURepository gpuRepository;
    private static final Logger logger = LoggerFactory.getLogger(GPUService.class);
    @Autowired
    public GPUService(GPURepository gpuRepository) {
        this.gpuRepository = gpuRepository;
    }

    public GPU gpuModel(List<String> gpuList) {
        GPU gpuModel = null;
        if (gpuList.size() == 1) {
            if (Objects.equals(gpuList.get(0), "Default")||Objects.equals(gpuList.get(0), "NONE")) {
                GPU gpu = new GPU();
                gpu.setModel("N/A");
                gpu.setBrand("");
                gpuModel = gpu;
                logger.info("GPU list size = 1, GPU default to None.");
                return gpuModel;
            }
        }
        // find the gpu with the highest score
        int score = Integer.MIN_VALUE;
        for(String gpuName : gpuList) {
            int firstIndex = gpuName.indexOf(' ');
            if(firstIndex!=-1){
                String brand = gpuName.substring(0,firstIndex);
                String model = gpuName.substring(firstIndex+1);
                logger.info("Find gpu: brand: {}, model: {}", brand, model);
                GPU gpu = gpuRepository.findByBrandAndModel(brand,model);
                if(gpu != null && gpu.getScore() > score) {
                    score = gpu.getScore();
                    gpuModel = gpu;
                }
            } else {
                logger.info("No space found in the string: {}. Unable to split.", gpuName);
            }
        }
        if(gpuModel==null){
            logger.info("No GPU is found, use GeForce RTX 3050(8 GB) to replace.");
            gpuModel = gpuRepository.findByBrandAndModel("NVIDIA","GeForce RTX 3050(8 GB)");
        }
        return gpuModel;
    }
}
