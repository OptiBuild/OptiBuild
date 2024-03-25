package com.optibuild.website.model.components;

import com.optibuild.website.model.Component;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class CPUCooler extends Component {
    @Getter
    @Setter
    private int size;
    private ArrayList<String> CPUSocket;
    private int height;
    private boolean RGB;
    private boolean addressable;

    public CPUCooler(long id, String brand, String model, int price, int score, int size, ArrayList<String> CPUSocket, int height, boolean RGB, boolean addressable) {
        super(id, brand, model, price, score);
        this.size = size;
        this.CPUSocket = CPUSocket;
        this.height = height;
        this.RGB = RGB;
        this.addressable = addressable;
    }

    public boolean checkCPUCoolerCompatibility (CPU model) {
        boolean compatible = false;
        // TODO

        return compatible;
    }

}
