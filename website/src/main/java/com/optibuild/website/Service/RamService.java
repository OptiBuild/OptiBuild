package com.optibuild.website.Service;

import com.optibuild.website.model.components.RAM;
import com.optibuild.website.repository.RAMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RamService {
    private final RAMRepository ramRepository;
    @Autowired
    public RamService(RAMRepository ramRepository) {
        this.ramRepository = ramRepository;
    }

    public RAM ramModel(List<String> storageList) {
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
        // find the ram model with the lowest price
        return findLowerPriceRAMWithSameSize(storage);
    }

    private RAM findLowerPriceRAMWithSameSize(int storage) {
        List<RAM> ramList = ramRepository.findBySize(storage);
        if (ramList.isEmpty()) return null;

        RAM lowestPriceRAM = ramList.get(0);
        for(RAM ram : ramList) {
            if (ram.getPrice() < lowestPriceRAM.getPrice()) {
                lowestPriceRAM = ram;
            }
        }
        return lowestPriceRAM;
    }
}
