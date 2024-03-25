package com.optibuild.website.model.components;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class HDD extends HardDrive{
    @Getter
    @Setter
    private int maxTransferRate;
    private int cache;

    public HDD(long id, String brand, String model, int price, int score, ArrayList<String> capacity, float formFactor, String hdInterface, boolean NVMe, int maxTransferRate, int cache) {
        super(id, brand, model, price, score, capacity, formFactor, hdInterface, NVMe);
        this.maxTransferRate = maxTransferRate;
        this.cache = cache;
    }
}
