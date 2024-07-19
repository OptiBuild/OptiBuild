package com.optibuild.website.Service;


import com.optibuild.website.model.components.CPU;
import com.optibuild.website.model.components.CPUCooler;
import com.optibuild.website.model.components.SocketCompatibility;
import com.optibuild.website.repository.SocketCompatibiltyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

@Service
public class CPUCoolerService {
    private static final Logger logger = LoggerFactory.getLogger(CPUCoolerService.class);
    private final SocketCompatibiltyRepository socketCompatibiltyRepository;
    @Autowired
    public CPUCoolerService (SocketCompatibiltyRepository socketCompatibiltyRepository) {
        this.socketCompatibiltyRepository = socketCompatibiltyRepository;
    }

    public CPUCooler cpuCooler(CPU cpu) {
//        Logger logger = LoggerFactory.getLogger(getClass());
        String socket = cpu.getSocketType();

        logger.info("Find CPUCooler compatible with socket: {}", socket);
        SocketCompatibility socketCompatibility = socketCompatibiltyRepository.findBySocketType(socket);
        if(socketCompatibility==null){
            logger.error("socket: {} {}", socket, "found no compatibility cpucooler.");
            return null;
        }
        Set<CPUCooler> cpuCoolers = socketCompatibility.getCpuCoolers();
        if(cpuCoolers==null){
            logger.error("No cpu cooler found.");
        }
        CPUCooler mostAffordableCooler = null;

        for (CPUCooler cooler : cpuCoolers) {
            if (mostAffordableCooler == null || cooler.getPrice() < mostAffordableCooler.getPrice()) {
                mostAffordableCooler = cooler;
            }
        }
        if(mostAffordableCooler==null){
            logger.error("No most affordable cpu cooler found.");
        } else {
            logger.info("Cpu cooler: {}", mostAffordableCooler.getModel());
        }

        return mostAffordableCooler;
    }
}
