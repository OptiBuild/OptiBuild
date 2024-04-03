package com.optibuild.website.model.components;

import com.optibuild.website.model.Component;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Motherboard extends Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String socket;
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

//    public Motherboard(long id, String brand, String model, int price, int score, String socket, String chipset, int memorySlot, int memoryStandard, int maxMemory, int DDRX, int PCIe4x16Slots, int SATASlots, int SATASpeed, int m2Slots, String m2Type, boolean supportNVMe, String formFactor) {
//        super(id, brand, model, price, score);
//        this.socket = socket;
//        this.chipset = chipset;
//        this.memorySlot = memorySlot;
//        this.memoryStandard = memoryStandard;
//        this.maxMemory = maxMemory;
//        this.DDRX = DDRX;
//        this.PCIe4x16Slots = PCIe4x16Slots;
//        this.SATASlots = SATASlots;
//        this.SATASpeed = SATASpeed;
//        M2Slots = m2Slots;
//        M2Type = m2Type;
//        this.supportNVMe = supportNVMe;
//        this.formFactor = formFactor;
//    }
}
