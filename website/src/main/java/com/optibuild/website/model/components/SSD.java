package com.optibuild.website.model.components;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class SSD extends HardDrive{
    @Getter
    @Setter
    private int maxSequentialRead;
    private int maxSequentialWrite;
    private String memoryComponent;

    public SSD(long id, String brand, String model, int price, int score, ArrayList<String> capacity, float formFactor, String hdInterface, boolean NVMe, int maxSequentialRead, int maxSequentialWrite, String memoryComponent) {
        super(id, brand, model, price, score, capacity, formFactor, hdInterface, NVMe);
        this.maxSequentialRead = maxSequentialRead;
        this.maxSequentialWrite = maxSequentialWrite;
        this.memoryComponent = memoryComponent;
    }
}
