package com.optibuild.website.model.components;

import com.optibuild.website.model.Component;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Motherboard extends Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String socketType;
    private String chipset;
    private int memorySlot;
    private int clockSpeed;
    private int maxMemory;
    private int DDRX;
    private int PCIe4x16Slots;
    private int SATASlots;
    private int SATASpeed;
    private int M2Slots;
    private String M2Type;
    private boolean supportNVMe;
    private String formFactor;


    public Motherboard() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSocketType() {
        return socketType;
    }

    public void setSocketType(String socketType) {
        this.socketType = socketType;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public int getMemorySlot() {
        return memorySlot;
    }

    public void setMemorySlot(int memorySlot) {
        this.memorySlot = memorySlot;
    }

    public int getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(int clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public int getMaxMemory() {
        return maxMemory;
    }

    public void setMaxMemory(int maxMemory) {
        this.maxMemory = maxMemory;
    }

    public int getDDRX() {
        return DDRX;
    }

    public void setDDRX(int DDRX) {
        this.DDRX = DDRX;
    }

    public int getPCIe4x16Slots() {
        return PCIe4x16Slots;
    }

    public void setPCIe4x16Slots(int PCIe4x16Slots) {
        this.PCIe4x16Slots = PCIe4x16Slots;
    }

    public int getSATASlots() {
        return SATASlots;
    }

    public void setSATASlots(int SATASlots) {
        this.SATASlots = SATASlots;
    }

    public int getSATASpeed() {
        return SATASpeed;
    }

    public void setSATASpeed(int SATASpeed) {
        this.SATASpeed = SATASpeed;
    }

    public int getM2Slots() {
        return M2Slots;
    }

    public void setM2Slots(int m2Slots) {
        M2Slots = m2Slots;
    }

    public String getM2Type() {
        return M2Type;
    }

    public void setM2Type(String m2Type) {
        M2Type = m2Type;
    }

    public boolean isSupportNVMe() {
        return supportNVMe;
    }

    public void setSupportNVMe(boolean supportNVMe) {
        this.supportNVMe = supportNVMe;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }
}
