package com.optibuild.website.model.components;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SocketCompatibility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String socketType;

    @ManyToOne
    @JoinColumn(name = "model")
    private CPUCooler cpuCooler;
}
