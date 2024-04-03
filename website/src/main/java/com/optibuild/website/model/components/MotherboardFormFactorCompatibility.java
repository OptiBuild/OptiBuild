package com.optibuild.website.model.components;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MotherboardFormFactorCompatibility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String formFactor;

    @ManyToOne
    @JoinColumn(name = "motherboard")
    private Case aCase;

}
