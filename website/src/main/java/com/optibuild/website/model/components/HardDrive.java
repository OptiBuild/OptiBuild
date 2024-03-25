package com.optibuild.website.model.components;

import com.optibuild.website.model.Component;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class HardDrive extends Component {
    @Getter
    @Setter
    protected ArrayList<String> capacity;
    protected float formFactor;
    protected String hdInterface;
    protected boolean NVMe;

    public HardDrive(long id, String brand, String model, int price, int score, ArrayList<String> capacity, float formFactor, String hdInterface, boolean NVMe) {
        super(id, brand, model, price, score);
        this.capacity = capacity;
        this.formFactor = formFactor;
        this.hdInterface = hdInterface;
        this.NVMe = NVMe;
    }
}
