package com.example.demo.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Pc extends Item{
    public enum FormFactor {
        DESKTOP("DESKTOP"), NETTOP("NETTOP"), MONO("MONO");
        FormFactor(String form) {};
    }

    private FormFactor formFactor;

    public FormFactor getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(FormFactor formFactor) {
        this.formFactor = formFactor;
    }
}
