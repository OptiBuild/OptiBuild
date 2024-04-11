package com.optibuild.website.model.components;

import com.optibuild.website.model.Component;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "`case`")
public class Case extends Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(name = "Case_FormFactorCompatibility",
            joinColumns = @JoinColumn(name = "case_id"),
            inverseJoinColumns = @JoinColumn(name = "formFactorType_id"))
    private Set<FormFactorCompatibility> formFactorCompatibilitySet = new HashSet<>();
    private int driveBays35;
    private int driveBays25;
    private int maxGPULength;
    private int maxCPUCoolerHeight;
    private int maxPSULength;
    private String dimension;
    private double weight;

//    public Case() {
//        this.brand = "Corsair";
//        this.model = "4000D Airflow";
//        this.price = 0; //TODO: unknown!
//        this.score = 0;
//        this.type = "ATX Mid Tower";
//        this.motherboardCompatibility = new ArrayList<>(List.of("Micro ATX", "ATX", "Mini ITX", "E-ATX (305mm x 277mm)"));
//        this.driveBays35 = 2;
//        this.driveBays25 = 2;
//        this.maxGPULength = 360;
//        this.maxCPUCoolerHeight = 170;
//        this.maxPSULength = 180;
//        this.dimension = "18.35 x 9.06 x 17.83";
//        this.weight = 17.31;
//    }


    public Case() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<FormFactorCompatibility> getFormFactorCompatibilitySet() {
        return formFactorCompatibilitySet;
    }

    public void setFormFactorCompatibilitySet(Set<FormFactorCompatibility> formFactorCompatibilitySet) {
        this.formFactorCompatibilitySet = formFactorCompatibilitySet;
    }

    public int getDriveBays35() {
        return driveBays35;
    }

    public void setDriveBays35(int driveBays35) {
        this.driveBays35 = driveBays35;
    }

    public int getDriveBays25() {
        return driveBays25;
    }

    public void setDriveBays25(int driveBays25) {
        this.driveBays25 = driveBays25;
    }

    public int getMaxGPULength() {
        return maxGPULength;
    }

    public void setMaxGPULength(int maxGPULength) {
        this.maxGPULength = maxGPULength;
    }

    public int getMaxCPUCoolerHeight() {
        return maxCPUCoolerHeight;
    }

    public void setMaxCPUCoolerHeight(int maxCPUCoolerHeight) {
        this.maxCPUCoolerHeight = maxCPUCoolerHeight;
    }

    public int getMaxPSULength() {
        return maxPSULength;
    }

    public void setMaxPSULength(int maxPSULength) {
        this.maxPSULength = maxPSULength;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
