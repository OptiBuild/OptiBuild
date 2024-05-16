package com.optibuild.website.model.components;

import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name = "socketcompatibility")
public class SocketCompatibility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String socketType;

    @ManyToMany(mappedBy = "socketCompatibilitySet")
    private Set<CPUCooler> cpuCoolers;

    public SocketCompatibility() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSocketType() {
        return socketType;
    }

    public void setSocketType(String socketType) {
        this.socketType = socketType;
    }

    public Set<CPUCooler> getCpuCoolers() {
        return cpuCoolers;
    }

    public void setCpuCoolers(Set<CPUCooler> cpuCoolers) {
        this.cpuCoolers = cpuCoolers;
    }
}
