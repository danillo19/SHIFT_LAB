package com.example.demo.contoller;

import com.example.demo.model.*;

public class ItemBuilder {

    public static final String PC = "Pc";
    public static final String DISK = "Disk";
    public static final String LAPTOP = "Laptop";
    public static final String DISPLAY = "Display";

    public Item build(ItemRequest request) {
        switch (request.getType()) {
            case PC: {
                Pc pc = new Pc();
                pc.setFormFactor(Pc.FormFactor.valueOf(request.getFormFactor()));
                return pc;
            }
            case DISK: {
                Disk disk = new Disk();
                disk.setCapacity(request.getCapacity());
                return disk;
            }
            case LAPTOP: {
                Laptop laptop = new Laptop();
                laptop.setSize(request.getLaptopSize());
                return laptop;
            }
            case DISPLAY: {
                Display display = new Display();
                display.setDiagonal(request.getDiagonal());
                return display;
            }
            default:
                return null;
        }
    }
}
