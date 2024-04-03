package com.optibuild.website.model.components;

import com.optibuild.website.model.Component;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Case extends Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private Set<MotherboardFormFactorCompatibility> motherboardFormFactorCompatibilitySet;
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

}
