package com.optibuild.website.model.components;
import jakarta.persistence.*;

@Entity
public class MotherboardFormFactorCompatibility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String formFactor;

    @ManyToOne
    @JoinColumn(name = "motherboard")
    private Case aCase;

    public MotherboardFormFactorCompatibility() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public Case getaCase() {
        return aCase;
    }

    public void setaCase(Case aCase) {
        this.aCase = aCase;
    }
}
