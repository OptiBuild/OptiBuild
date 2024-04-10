package com.optibuild.website.model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Component {
    protected String brand;
    protected String model;
    protected double price;

    public Component() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
