package com.optibuild.website.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

}
