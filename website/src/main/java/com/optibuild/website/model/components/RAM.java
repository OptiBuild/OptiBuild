package com.optibuild.website.model.components;

import com.optibuild.website.model.Component;
import jakarta.persistence.*;

@Entity
public class RAM extends Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int DDRVersion;
    private int stickNum;
    private int size;
    private int clockSpeed;
    private double voltage;
    private boolean RGB;

    public RAM() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDDRVersion() {
        return DDRVersion;
    }

    public void setDDRVersion(int DDRVersion) {
        this.DDRVersion = DDRVersion;
    }

    public int getStickNum() {
        return stickNum;
    }

    public void setStickNum(int stickNum) {
        this.stickNum = stickNum;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(int clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public boolean isRGB() {
        return RGB;
    }

    public void setRGB(boolean RGB) {
        this.RGB = RGB;
    }
}
