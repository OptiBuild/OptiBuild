package com.optibuild.website.Service;

import com.optibuild.website.model.components.CPU;
import com.optibuild.website.model.components.CPUCooler;
import com.optibuild.website.model.components.SocketCompatibility;
import com.optibuild.website.repository.SocketCompatibiltyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CPUCoolerService {
    private final SocketCompatibiltyRepository socketCompatibiltyRepository;
    @Autowired
    public CPUCoolerService (SocketCompatibiltyRepository socketCompatibiltyRepository) {
        this.socketCompatibiltyRepository = socketCompatibiltyRepository;
    }

    public CPUCooler cpuCooler(CPU cpu) {
        String socket = cpu.getSocketType();
        SocketCompatibility socketCompatibility = socketCompatibiltyRepository.findBySocketType(socket);
        Set<CPUCooler> cpuCoolers = socketCompatibility.getCpuCoolers();
        CPUCooler mostAffordableCooler = null;

        for (CPUCooler cooler : cpuCoolers) {
            if (mostAffordableCooler == null || cooler.getPrice() < mostAffordableCooler.getPrice()) {
                mostAffordableCooler = cooler;
            }
        }

        return mostAffordableCooler;
    }
}
