package com.optibuild.website.model.components;

import com.optibuild.website.model.Component;
import jakarta.persistence.*;

@Entity
public class PowerSupply extends Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private int maxPower;
    private int maxPSULength;
    private PowerSupplyModular modular;

    public PowerSupply() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(int maxPower) {
        this.maxPower = maxPower;
    }

    public int getMaxPSULength() {
        return maxPSULength;
    }

    public void setMaxPSULength(int maxPSULength) {
        this.maxPSULength = maxPSULength;
    }

    public PowerSupplyModular getModular() {
        return modular;
    }

    public void setModular(PowerSupplyModular modular) {
        this.modular = modular;
    }
}
