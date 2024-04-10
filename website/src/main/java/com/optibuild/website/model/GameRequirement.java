package com.optibuild.website.model;

import jakarta.persistence.*;

@Entity
public class GameRequirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name") // 替换为您表中对应的列名，下同
    private String name;
    @Column(name = "pc_requirements")
    private String pcRequirements;
    @Column(name = "os")
    private String os;
    @Column(name = "processor")
    private String processor;
    @Column(name = "memory")
    private int memory;
    @Column(name = "graphics")
    private String graphics;
    @Column(name = "directx")
    private String directX;
    @Column(name = "network")
    private String network;
    @Column(name = "storage")
    private int storage;
    @Column(name = "additional_notes")
    private String additionalNotes;

    public GameRequirement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPcRequirements() {
        return pcRequirements;
    }

    public void setPcRequirements(String pcRequirements) {
        this.pcRequirements = pcRequirements;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getGraphics() {
        return graphics;
    }

    public void setGraphics(String graphics) {
        this.graphics = graphics;
    }

    public String getDirectX() {
        return directX;
    }

    public void setDirectX(String directX) {
        this.directX = directX;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }
}
