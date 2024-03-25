package com.optibuild.website.model.components;

import com.optibuild.website.model.Component;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Case extends Component {
    @Getter
    @Setter
    private String type;
    private ArrayList<String> motherboardCompatibility;
    private int driveBays35;
    private int driveBays25;
    private int maxGPULength;
    private int maxCPUCoolerHeight;
    private int maxPSULength;
    private String dimension;
    private double weight;

    public Case() {
        this.brand = "Corsair";
        this.model = "4000D Airflow";
        this.price = 0; //TODO: unknown!
        this.score = 0;
        this.type = "ATX Mid Tower";
        this.motherboardCompatibility = new ArrayList<>(List.of("Micro ATX", "ATX", "Mini ITX", "E-ATX (305mm x 277mm)"));
        this.driveBays35 = 2;
        this.driveBays25 = 2;
        this.maxGPULength = 360;
        this.maxCPUCoolerHeight = 170;
        this.maxPSULength = 180;
        this.dimension = "18.35 x 9.06 x 17.83";
        this.weight = 17.31;
    }

    public Case(long id, String brand, String model, int price, int score, String type, ArrayList<String> motherboardCompatibility, int driveBays35, int driveBays25, int maxGPULength, int maxCPUCoolerHeight, int maxPSULength, String dimension, float weight) {
        super(id, brand, model, price, score);
        this.type = type;
        this.motherboardCompatibility = motherboardCompatibility;
        this.driveBays35 = driveBays35;
        this.driveBays25 = driveBays25;
        this.maxGPULength = maxGPULength;
        this.maxCPUCoolerHeight = maxCPUCoolerHeight;
        this.maxPSULength = maxPSULength;
        this.dimension = dimension;
        this.weight = weight;
    }
}
