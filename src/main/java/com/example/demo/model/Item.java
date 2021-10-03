package com.example.demo.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.type.UUIDCharType;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "item_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "item_type", insertable = false, updatable = false)
    private String type;

    private String producer;

    private Integer price;

    private Integer countOnStore;


    public String getProducer() { return producer; }

    public void setProducer(String producer) { this.producer = producer; }

    public Integer getPrice() {
        return price;
    }

    public String getType() { return type; }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCountOnStore() {
        return countOnStore;
    }

    public void setType(String type) { this.type = type; }

    public void setCountOnStore(Integer countOnStore) {
        this.countOnStore = countOnStore;
    }
}
