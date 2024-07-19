package com.optibuild.website.Service;

import com.optibuild.website.model.components.HDD;
import com.optibuild.website.model.components.SSD;
import com.optibuild.website.repository.HardDriveRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class HardDriveService {
    private static final Logger logger = LoggerFactory.getLogger(HardDriveService.class);
    private final HardDriveRepository hardDriveRepository;
    @Autowired
    public HardDriveService (HardDriveRepository hardDriveRepository) {
        this.hardDriveRepository = hardDriveRepository;
    }

    public String hardDrive(List<String> hardDriveList, double price) {
        logger.info("Received hard drive list: {}", hardDriveList);
        logger.info("Received price: {}", price);

        int gbSize = 0;
        if (hardDriveList.size() == 1) {
            gbSize = Integer.parseInt(hardDriveList.get(0));
        } else {
            for (int i = 1; i < hardDriveList.size(); i++) {
                gbSize += Integer.parseInt(hardDriveList.get(i));
            }
                gbSize = gbSize*1.4 > Integer.parseInt(hardDriveList.get(0)) ? (int) Math.ceil(gbSize * 1.4) : Integer.parseInt(hardDriveList.get(0));
        }
        logger.info("Calculated gbSize: {}", gbSize);
        String result = hardDriveModel(gbSize, price);
        logger.info("Final hard drive model result: {}", result);

        return result;
    }

    private String hardDriveModel(int size, double price) {
        logger.info("Calculating hard drive model for size: {} and price: {}", size, price);
        String hdd;
        String ssd;
        double hddPrice = 0;
        double ssdPrice = 0;
        if (size >= 4*1024) {
            hdd = findLowestPrice("HDD", "4TB", hddPrice);
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

        logger.info("Calculated total price: {}", price);
        return hdd+","+ssd;
    }

    private String findLowestPrice(String type, String capacity, double price) {
        logger.info("Finding lowest price for type: {} and capacity: {}", type, capacity);

        if (Objects.equals(type, "HDD")) {
            List<HDD> hdds = hardDriveRepository.findHDDByCapacityGreaterThanEqual(capacity);
            if (hdds.isEmpty()) {
                logger.error("No HDDs found for capacity: {}", capacity);
                return "No HDD found";
            }
            HDD lowestPriceHDD = hdds.get(0);
            for(HDD hdd : hdds) {
                if(hdd.getPrice()<lowestPriceHDD.getPrice()) {
                    lowestPriceHDD = hdd;
                    price = hdd.getPrice();
                }
            }
            logger.info("Lowest price HDD: {} {}", lowestPriceHDD.getBrand(), lowestPriceHDD.getModel());
            return lowestPriceHDD.getBrand()+" "+lowestPriceHDD.getModel();
        } else {
            List<SSD> ssds = hardDriveRepository.findSSDByCapacityAndHdInterface(capacity, "M.2");
            if (ssds.isEmpty()) {
                ssds = hardDriveRepository.findSSDByCapacity(capacity);
                if(ssds.isEmpty()){
                    logger.error("No SSDs found for capacity (equal or greater than): {}", capacity);
                    return "No SSD found";
                }
            }
            SSD lowestPriceSSD = ssds.get(0);
            for(SSD ssd : ssds) {
                if(ssd.getPrice()< lowestPriceSSD.getPrice()) {
                    lowestPriceSSD = ssd;
                    price = ssd.getPrice();
                }
            }

            logger.info("Lowest price SSD: {} {}", lowestPriceSSD.getBrand(), lowestPriceSSD.getModel());
            return lowestPriceSSD.getBrand()+" "+lowestPriceSSD.getModel();
        }
    }
}
