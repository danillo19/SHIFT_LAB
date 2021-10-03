package com.example.demo.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Disk extends Item{
    private Integer capacity;

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
