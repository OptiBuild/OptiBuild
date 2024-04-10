package com.optibuild.website.model.components;

import com.optibuild.website.model.Component;
import jakarta.persistence.*;

@Entity
public class GPU extends Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int score;
    private int codaCoreNum;
    private int baseClock;
    private int boostClock;
    private int memory;
    private int memoryClock;
    private int requestSystemPower;
    private int length;

    public GPU() {
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

    public int getCodaCoreNum() {
        return codaCoreNum;
    }

    public void setCodaCoreNum(int codaCoreNum) {
        this.codaCoreNum = codaCoreNum;
    }

    public int getBaseClock() {
        return baseClock;
    }

    public void setBaseClock(int baseClock) {
        this.baseClock = baseClock;
    }

    public int getBoostClock() {
        return boostClock;
    }

    public void setBoostClock(int boostClock) {
        this.boostClock = boostClock;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getMemoryClock() {
        return memoryClock;
    }

    public void setMemoryClock(int memoryClock) {
        this.memoryClock = memoryClock;
    }

    public int getRequestSystemPower() {
        return requestSystemPower;
    }

    public void setRequestSystemPower(int requestSystemPower) {
        this.requestSystemPower = requestSystemPower;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
