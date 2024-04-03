package com.optibuild.website.Service;

import com.optibuild.website.model.components.*;
import com.optibuild.website.repository.HardDriveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ComponentService {
    private final CPUService cpuService;
    private final GPUService gpuService;
    private final RamService ramService;
    private final HardDriveService hardDriveService;
    private final CPUCoolerService cpuCoolerService;
    private final PowerSupplyService powerSupplyService;
    private final MotherboardService motherboardService;
    private final CaseService caseService;
    private final HardDriveRepository hardDriveRepository;
    @Autowired
    public ComponentService(HardDriveRepository hardDriveRepository, CPUService cpuService, GPUService gpuService, RamService ramService, HardDriveService hardDriveService, CPUCoolerService cpuCoolerService, PowerSupplyService powerSupplyService, MotherboardService motherboardService, CaseService caseService) {
        this.cpuService = cpuService;
        this.gpuService = gpuService;
        this.ramService = ramService;
        this.hardDriveService = hardDriveService;
        this.cpuCoolerService = cpuCoolerService;
        this.powerSupplyService = powerSupplyService;
        this.motherboardService = motherboardService;
        this.caseService = caseService;
        this.hardDriveRepository = hardDriveRepository;
    }


    public Map<String, String> getMatchingComponents(List<List<String>> specifications) {
        Map<String, String> components = new HashMap<>();
        int index = 1;
        CPU cpu = cpuService.cpuModel(specifications.get(index++));
        GPU gpu = gpuService.gpuModel(specifications.get(index++));
        RAM ram = ramService.ramModel(specifications.get(index++));
        String hardDrive = hardDriveService.hardDrive(specifications.get(index++));
        String[] parts = hardDrive.split(",");
        String hdd = parts[0];
        String ssd = parts[1];
        CPUCooler cpuCooler = cpuCoolerService.cpuCooler(cpu);
        PowerSupply powerSupply = powerSupplyService.powerSupplyModel(cpu, gpu);
        Motherboard motherboard = motherboardService.motherboard(cpu,gpu,ram,hardDriveRepository.findBymodel(hdd));
        Case computerCase = caseService.getCase(gpu, motherboard, powerSupply, cpuCooler);

        // 将各个组件添加到 Map
        components.put("CPU", formatComponent(cpu.getBrand(), cpu.getModel()));
        components.put("GPU", formatComponent(gpu.getBrand(), gpu.getModel()));
        components.put("RAM", formatComponent(ram.getBrand(), ram.getModel()));
        components.put("HardDrive", hardDrive);
        components.put("CPUCooler", formatComponent(cpuCooler.getBrand(), cpuCooler.getModel()));
        components.put("PowerSupply", formatComponent(powerSupply.getBrand(), powerSupply.getModel()));
        components.put("Motherboard", formatComponent(motherboard.getBrand(), motherboard.getModel()));
        components.put("Case", formatComponent(computerCase.getBrand(), computerCase.getModel()));
        return components;
    }

    private String formatComponent(String brand, String model) {
        return brand + " " + model;
    }

}
