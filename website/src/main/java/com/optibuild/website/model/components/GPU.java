package com.optibuild.website.model.components;

import com.optibuild.website.model.Component;
import lombok.Getter;
import lombok.Setter;

public class GPU extends Component {
    @Getter
    @Setter
    private int codaCoreNum;
    private int baseClock;
    private int boostClock;
    private int memory;
    private int memoryClock;
    private int requestSystemPower;

    public GPU(long id, String brand, String model, int price, int score, int codaCoreNum, int baseClock, int boostClock, int memory, int memoryClock, int requestSystemPower) {
        super(id, brand, model, price, score);
        this.codaCoreNum = codaCoreNum;
        this.baseClock = baseClock;
        this.boostClock = boostClock;
        this.memory = memory;
        this.memoryClock = memoryClock;
        this.requestSystemPower = requestSystemPower;
    }
}
