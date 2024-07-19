package com.optibuild.website.model.components;

import com.optibuild.website.model.Component;
import jakarta.persistence.*;
import java.util.Set;

@Entity
public class CPUCooler extends Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int size;
//    private String CPUSocket;
    @ManyToMany
    @JoinTable(
            name = "cpucooler_socket_compatibility", // 联结表名
            joinColumns = @JoinColumn(name = "cooler_id"), // CPUCooler 表的外键
            inverseJoinColumns = @JoinColumn(name = "compatibility_id") // SocketCompatibility 表的外键
    )
    private Set<SocketCompatibility> socketCompatibilitySet;
    private int height;
    private boolean RGB;
    private boolean addressable;

    public CPUCooler() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Set<SocketCompatibility> getSocketCompatibilitySet() {
        return socketCompatibilitySet;
    }

    public void setSocketCompatibilitySet(Set<SocketCompatibility> socketCompatibilitySet) {
        this.socketCompatibilitySet = socketCompatibilitySet;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isRGB() {
        return RGB;
    }

    public void setRGB(boolean RGB) {
        this.RGB = RGB;
    }

    public boolean isAddressable() {
        return addressable;
    }

    public void setAddressable(boolean addressable) {
        this.addressable = addressable;
    }
}
