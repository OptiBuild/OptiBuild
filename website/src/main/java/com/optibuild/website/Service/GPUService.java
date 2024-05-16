package com.optibuild.website.Service;

import com.optibuild.website.model.components.GPU;
import com.optibuild.website.repository.GPURepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GPUService {
    @Autowired
    private final GPURepository gpuRepository;
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
            }
        } else {
            // find the gpu with the highest score
            int score = Integer.MIN_VALUE;
            for(String model : gpuList) {
                GPU gpu = gpuRepository.findByModel(model);
                if(gpu != null && gpu.getScore() > score) {
                    score = gpu.getScore();
                    gpuModel = gpu;
                }

            }
        }
        return gpuModel;
    }
}
