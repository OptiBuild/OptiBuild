package com.optibuild.website.Service;

import com.optibuild.website.model.components.RAM;
import com.optibuild.website.repository.RAMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class RamService {
    private static final Logger logger = LoggerFactory.getLogger(RamService.class);
    private final RAMRepository ramRepository;
    @Autowired
    public RamService(RAMRepository ramRepository) {
        this.ramRepository = ramRepository;
    }

    public RAM ramModel(List<String> storageList) {
        int storage = largestStorage(storageList);
        List<RAM> ramList = ramRepository.findBySize(storage);
        if(ramList.isEmpty()){
            ramList.addAll(ramRepository.findBySizeGreaterThan(storage-1));
        }
        // find the ram model with the lowest price
        RAM ram = findLowerPriceRAMWithSameSize(ramList);
        if(ram==null){
            logger.error("No ram found.");
        }
        return ram;
    }

    private int largestStorage(List<String> storageList){
        int storage = 0;
        if (storageList.size() == 1) {
            storage = Integer.parseInt(storageList.get(0));
        } else {
            // find the largest storage requirement
            for (String stringStorage : storageList) {
                int temp = Integer.parseInt(stringStorage);
                if (temp > storage) {
                    storage = temp;
                }
            }
        }
        return storage;
    }

    private RAM findLowerPriceRAMWithSameSize(List<RAM> ramList) {
        if (ramList.isEmpty()) return null;

        RAM lowestPriceRAM = ramList.get(0);
        for(RAM ram : ramList) {
            if (ram.getPrice() < lowestPriceRAM.getPrice()) {
                lowestPriceRAM = ram;
            }
        }
        return lowestPriceRAM;
    }

    public RAM ramModelWithDDRX(List<String> storageList, int ddrx) {
        int storage = largestStorage(storageList);
        List<RAM> ramList = ramRepository.findBySizeAndDDRVersion(storage, ddrx);
        if(ramList.isEmpty()){
            ramList.addAll(ramRepository.findBySizeGreaterThanAndDDRVersion(storage-1, ddrx));
        }
        RAM ram = findLowerPriceRAMWithSameSize(ramList);
        if(ram==null){
            logger.error("No ram with DDRVersion: {} found", ddrx);
        }
        return ram;
    }
}
