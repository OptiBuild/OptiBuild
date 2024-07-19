package com.optibuild.website.model.components;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "form_factor_compatibility")
public class FormFactorCompatibility {
    @Id
    @GeneratedValue
    private Long id;

    String formFactorType;

    @ManyToMany(mappedBy = "formFactorCompatibilitySet")
    private Set<Case> compatibleCases = new HashSet<>();

    public FormFactorCompatibility() {
    }

    public String getFormFactorType() {
        return formFactorType;
    }

    public void setFormFactorType(String formFactorType) {
        this.formFactorType = formFactorType;
    }

    public Set<Case> getCompatibleCases() {
        return compatibleCases;
    }

    public void setCompatibleCases(Set<Case> compatibleCases) {
        this.compatibleCases = compatibleCases;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
