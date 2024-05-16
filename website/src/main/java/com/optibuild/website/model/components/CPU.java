package com.optibuild.website.model.components;

import com.optibuild.website.model.Component;
import jakarta.persistence.*;

@Entity
public class CPU extends Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int score;
    private int coreNum;
    private int threadNum;
    private float upperClock;
    private float lowerClock;
    @Column(name = "socketType")
    private String socketType;
    private int L3Cache;
    private int TDP;

    public CPU() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCoreNum() {
        return coreNum;
    }

    public void setCoreNum(int coreNum) {
        this.coreNum = coreNum;
    }

    public int getThreadNum() {
        return threadNum;
    }

    public void setThreadNum(int threadNum) {
        this.threadNum = threadNum;
    }

    public float getUpperClock() {
        return upperClock;
    }

    public void setUpperClock(float upperClock) {
        this.upperClock = upperClock;
    }

    public float getLowerClock() {
        return lowerClock;
    }

    public void setLowerClock(float lowerClock) {
        this.lowerClock = lowerClock;
    }

    public String getSocketType() {
        return socketType;
    }

    public void setSocketType(String socketType) {
        this.socketType = socketType;
    }

    public int getL3Cache() {
        return L3Cache;
    }

    public void setL3Cache(int l3Cache) {
        L3Cache = l3Cache;
    }

    public int getTDP() {
        return TDP;
    }

    public void setTDP(int TDP) {
        this.TDP = TDP;
    }
}
