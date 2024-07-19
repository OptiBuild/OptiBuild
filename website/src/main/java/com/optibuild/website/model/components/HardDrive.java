package com.optibuild.website.model.components;

import com.optibuild.website.model.Component;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class HardDrive extends Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String capacity;
    protected float formFactor;
    protected String hdInterface;
    @Column(name = "nvme")
    protected boolean NVMe;

    public HardDrive() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public float getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(float formFactor) {
        this.formFactor = formFactor;
    }

    public String getHdInterface() {
        return hdInterface;
    }

    public void setHdInterface(String hdInterface) {
        this.hdInterface = hdInterface;
    }

    public boolean isNVMe() {
        return NVMe;
    }

    public void setNVMe(boolean NVMe) {
        this.NVMe = NVMe;
    }
}
