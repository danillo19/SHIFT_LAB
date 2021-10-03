package com.example.demo.model;


import javax.persistence.*;

@Entity
public class Laptop extends Item {
    private Integer size;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
