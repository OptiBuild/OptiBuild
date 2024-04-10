package com.optibuild.website.Service;

import com.optibuild.website.model.components.CPU;
import com.optibuild.website.model.components.CPUCooler;
import com.optibuild.website.repository.CPUCoolerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CPUCoolerService {
    private final CPUCoolerRepository cpuCoolerRepository;
    @Autowired
    public CPUCoolerService (CPUCoolerRepository cpuCoolerRepository) {
        this.cpuCoolerRepository = cpuCoolerRepository;
    }

    public CPUCooler cpuCooler(CPU cpu) {
        String socket = cpu.getSocketType();
        List<CPUCooler> cpuCoolerList = cpuCoolerRepository.findBySocketType(socket);
        CPUCooler cpuCooler = cpuCoolerList.get(0);
        double price = cpuCooler.getPrice();
        for (int i = 1; i<cpuCoolerList.size(); i++) {
            if(cpuCoolerList.get(i).getPrice() < price) {
                cpuCooler = cpuCoolerList.get(i);
                price = cpuCooler.getPrice();
            }
        }
        return cpuCooler;
    }
}
