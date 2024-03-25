package com.optibuild.website.model.components;

import com.optibuild.website.model.Component;
import lombok.Getter;
import lombok.Setter;


public class PowerSupply extends Component {
    @Getter
    @Setter
    private String type;
    private int maxPower;
    private int maxPSULength;
    private PowerSupplyModular modular;

    public PowerSupply(long id, String brand, String model, int price, int score, String type, int maxPower, int maxPSULength, PowerSupplyModular modular) {
        super(id, brand, model, price, score);
        this.type = type;
        this.maxPower = maxPower;
        this.maxPSULength = maxPSULength;
        this.modular = modular;
    }
}
