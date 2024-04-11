package com.optibuild.website.Service;

import com.optibuild.website.model.components.*;
import com.optibuild.website.repository.MotherboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotherboardService {
    private final MotherboardRepository motherboardRepository;
    @Autowired
    public MotherboardService (MotherboardRepository motherboardRepository) {
        this.motherboardRepository = motherboardRepository;
    }

    // Ensure compatibility with all previous components
    public Motherboard motherboard(CPU cpu, GPU gpu, RAM ram, HardDrive hardDrive) {
        String socket = null;
        if(cpu != null) {
            socket = cpu.getSocketType();
        }
        int clockspeed = 0;
        int ddr = 5;
        if(ram != null) {
            clockspeed = ram.getClockSpeed() - 1;
            ddr = ram.getDDRVersion();
        }
        boolean nvme = false;
        if(hardDrive != null) {
            nvme = hardDrive.isNVMe();
        }
        List<Motherboard> motherboardList = motherboardRepository.findBySocketTypeAndDDRXAndClockSpeedGreaterThanAndSupportNVMe(socket, ddr, clockspeed, nvme);
        Motherboard motherboard = motherboardList.get(0);
        for (Motherboard mb : motherboardList) {
            double price = motherboard.getPrice();
            if (price > mb.getPrice()) {
                motherboard = mb;
            }
        }
        return motherboard;
    }
}
