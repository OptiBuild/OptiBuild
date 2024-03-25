package com.optibuild.website.model.components;

import com.optibuild.website.model.Component;
import lombok.Getter;
import lombok.Setter;

public class RAM extends Component {
    @Getter
    @Setter
    private int DDRVersion;
    private int stickNum;
    private int memorySize;
    private int clockSpeed;
    private float voltage;
    private boolean RGB;

    public RAM(long id, String brand, String model, int price, int score, int DDRVersion, int stickNum, int memorySize, int clockSpeed, float voltage, boolean RGB) {
        super(id, brand, model, price, score);
        this.DDRVersion = DDRVersion;
        this.stickNum = stickNum;
        this.memorySize = memorySize;
        this.clockSpeed = clockSpeed;
        this.voltage = voltage;
        this.RGB = RGB;
    }
}
