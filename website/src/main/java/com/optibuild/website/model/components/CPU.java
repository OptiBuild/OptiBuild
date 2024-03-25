package com.optibuild.website.model.components;

import com.optibuild.website.model.Component;
import lombok.Getter;
import lombok.Setter;

public class CPU extends Component {
    @Getter
    @Setter
    private int coreNum;
    private int threadNum;
    private float upperClock;
    private float lowerClock;
    private String socketType;
    private int size;
    private int L3Cache;
    private int TDP;

    public CPU(long id, String brand, String model, int price, int score, int coreNum, int threadNum, float upperClock, float lowerClock, String socketType, int size, int l3Cache, int TDP) {
        super(id, brand, model, price, score);
        this.coreNum = coreNum;
        this.threadNum = threadNum;
        this.upperClock = upperClock;
        this.lowerClock = lowerClock;
        this.socketType = socketType;
        this.size = size;
        L3Cache = l3Cache;
        this.TDP = TDP;
    }
}
