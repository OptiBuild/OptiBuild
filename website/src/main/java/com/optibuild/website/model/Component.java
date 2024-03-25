package com.optibuild.website.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Component {
    @Getter
    @Setter
    @Id
    protected Long id;
    protected String brand;
    protected String model;
    protected float price;
    protected long score;

    public Component() {

    }
    public Component(Long id, String brand, String model, float price, long score) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.score = score;
    }
}
