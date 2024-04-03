package com.optibuild.website.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class GameRequirement {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Setter
    @Column(name = "name") // 替换为您表中对应的列名，下同
    private String name;

    @Getter
    @Setter
    @Column(name = "pc_requirements")
    private String pcRequirements;

    @Getter
    @Setter
    @Column(name = "os")
    private String os;

    @Getter
    @Setter
    @Column(name = "processor")
    private String processor;

    @Getter
    @Setter
    @Column(name = "memory")
    private int memory;

    @Getter
    @Setter
    @Column(name = "graphics")
    private String graphics;

    @Getter
    @Setter
    @Column(name = "directx")
    private String directX;

    @Getter
    @Setter
    @Column(name = "network")
    private String network;

    @Getter
    @Setter
    @Column(name = "storage")
    private int storage;

    @Getter
    @Setter
    @Column(name = "sound_card")
    private String soundCard;

    @Getter
    @Setter
    @Column(name = "additional_notes")
    private String additionalNotes;

}
