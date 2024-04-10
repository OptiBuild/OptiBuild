package com.optibuild.website.model.components;


import jakarta.persistence.*;

@Entity
public class SocketCompatibility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String socketType;

    @ManyToOne
    @JoinColumn(name = "model")
    private CPUCooler cpuCooler;

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

    public CPUCooler getCpuCooler() {
        return cpuCooler;
    }

    public void setCpuCooler(CPUCooler cpuCooler) {
        this.cpuCooler = cpuCooler;
    }
}
