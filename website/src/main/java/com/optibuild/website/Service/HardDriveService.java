package com.optibuild.website.Service;

import com.optibuild.website.model.components.HDD;
import com.optibuild.website.model.components.HardDrive;
import com.optibuild.website.model.components.SSD;
import com.optibuild.website.repository.HardDriveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HardDriveService {
    private final HardDriveRepository hardDriveRepository;
    @Autowired
    public HardDriveService (HardDriveRepository hardDriveRepository) {
        this.hardDriveRepository = hardDriveRepository;
    }

    public String hardDrive(List<String> hardDriveList, double price) {
        int gbSize = 0;
        if (hardDriveList.size() == 1) {
            gbSize = Integer.parseInt(hardDriveList.get(0));
        } else {
            for (int i = 1; i < hardDriveList.size(); i++) {
                gbSize += Integer.parseInt(hardDriveList.get(i));
            }
                gbSize = gbSize*1.4 > Integer.parseInt(hardDriveList.get(0)) ? (int) Math.ceil(gbSize * 1.4) : Integer.parseInt(hardDriveList.get(0));
        }
        return hardDriveModel(gbSize, price);
    }

    private String hardDriveModel(int size, double price) {
        String hdd;
        String ssd;
        double hddPrice = 0;
        double ssdPrice = 0;
        if (size >= 4*1024) {
            hdd = findLowestPrice("HDD", "2TB", hddPrice);
            ssd = findLowestPrice("SSD", "2TB", ssdPrice);
        } else if (size >= 2*1024) {
            hdd = findLowestPrice("HDD", "2TB", hddPrice);
            ssd = findLowestPrice("SSD", "1TB", ssdPrice);
        } else if (size >= 1024) {
            hdd = findLowestPrice("HDD", "1TB", hddPrice);
            ssd = findLowestPrice("SSD", "500GB", ssdPrice);
        } else if (size >= 500) {
            hdd = findLowestPrice("HDD", "500GB", hddPrice);
            ssd = findLowestPrice("SSD", "500GB", ssdPrice);
        } else {
            hdd = "";
            ssd = findLowestPrice("SSD", "500GB", ssdPrice);
        }
        price = hddPrice + ssdPrice;
        return hdd+","+ssd;
    }

    private String findLowestPrice(String type, String capacity, double price) {
        if (type == "HDD") {
            List<HDD> hdds = hardDriveRepository.findHDDByCapacity(capacity);
            HDD lowestPriceHDD = hdds.get(0);
            for(HDD hdd : hdds) {
                if(hdd.getPrice()<lowestPriceHDD.getPrice()) {
                    lowestPriceHDD = hdd;
                    price = hdd.getPrice();
                }
            }
            return lowestPriceHDD.getBrand()+lowestPriceHDD.getModel();
        } else {
            List<SSD> ssds = hardDriveRepository.findSSDByCapacityAndHdInterface(capacity, "M.2");
            SSD lowestPriceSSD = ssds.get(0);
            for(SSD ssd : ssds) {
                if(ssd.getPrice()< lowestPriceSSD.getPrice()) {
                    lowestPriceSSD = ssd;
                    price = ssd.getPrice();
                }
            }
            return lowestPriceSSD.getBrand()+lowestPriceSSD.getModel();
        }
    }
}
