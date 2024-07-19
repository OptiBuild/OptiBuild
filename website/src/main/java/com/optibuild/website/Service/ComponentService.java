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
        if (cpu == null) {
            return getErrorMap("CPU");
        }

        GPU gpu = gpuService.gpuModel(specifications.get(index++));
        if (gpu == null) {
            return getErrorMap("GPU");
        }

        double hardDrivePrice = 0;
        String hardDrive = hardDriveService.hardDrive(specifications.get(index++), hardDrivePrice);

        if (hardDrive == null) {
            return getErrorMap("HardDrive");
        }

        List<String> storageList = specifications.get(index+2);
        RAM ram = ramService.ramModel(storageList);
        if (ram == null) {
            return getErrorMap("RAM");
        }

        String[] parts = hardDrive.split(",");
        String hdd = parts[0];
        String ssd = parts[1];

        CPUCooler cpuCooler = cpuCoolerService.cpuCooler(cpu);
        if (cpuCooler == null) {
            return getErrorMap("CPU Cooler");
        }

        PowerSupply powerSupply = powerSupplyService.powerSupplyModel(cpu, gpu);
        if (powerSupply == null) {
            return getErrorMap("Power Supply");
        }
        Motherboard motherboard = motherboardService.motherboard(cpu,gpu,ram,hardDriveRepository.findBymodel(hdd));
        if(motherboard==null && ram.getDDRVersion()==4){
            ram = ramService.ramModelWithDDRX(storageList, 5);
            motherboard = motherboardService.motherboard(cpu,gpu,ram,hardDriveRepository.findBymodel(hdd));
        }
        if (motherboard == null) {
            return getErrorMap("Motherboard");
        }

        List<Case> caseList = caseService.getCaseList(gpu, motherboard, powerSupply, cpuCooler);
        Case computerCase = caseService.getCase(caseList);
        if (computerCase == null) {
            return getErrorMap("case");
        }

        double totalPrice = cpu.getPrice() + gpu.getPrice() + ram.getPrice() + hardDrivePrice + cpuCooler.getPrice() + powerSupply.getPrice() + motherboard.getPrice() + computerCase.getPrice();


        components.put("CPU", formatComponent(cpu.getBrand(), cpu.getModel()));
        components.put("GPU", formatComponent(gpu.getBrand(), gpu.getModel()));
        components.put("RAM", formatComponent(ram.getBrand(), ram.getModel()));
        components.put("HardDrive", hardDrive);
        components.put("CPUCooler", formatComponent(cpuCooler.getBrand(), cpuCooler.getModel()));
        components.put("PowerSupply", formatComponent(powerSupply.getBrand(), powerSupply.getModel()));
        components.put("Motherboard", formatComponent(motherboard.getBrand(), motherboard.getModel()));
        components.put("Case", formatComponent(computerCase.getBrand(), computerCase.getModel()));
        
        components.put("Cost", String.valueOf(totalPrice));
        return components;
    }

    private Map<String, String> getErrorMap(String componentName) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("Error", "Unable to find a suitable " + componentName);
        return errorMap;
    }

    private String formatComponent(String brand, String model) {
        return brand + " " + model;
    }

}
