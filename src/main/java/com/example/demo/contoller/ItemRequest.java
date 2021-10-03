package com.example.demo.contoller;


import javax.validation.constraints.NotNull;

public class ItemRequest {
    private Long id;


    @NotNull(message = "Empty type")
    private String type;

    @NotNull
    private String producer;

    @NotNull
    private Integer price;

    @NotNull
    private Integer countOnStore;

    private Integer laptopSize;

    private String formFactor;

    private Integer capacity;

    private Integer diagonal;


    public Integer getCountOnStore() {
        return countOnStore;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getProducer() {
        return producer;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getLaptopSize() {
        return laptopSize;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Integer getDiagonal() {
        return diagonal;
    }
}
