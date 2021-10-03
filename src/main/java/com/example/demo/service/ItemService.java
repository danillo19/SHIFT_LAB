package com.example.demo.service;

import com.example.demo.contoller.ItemRequest;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;


    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public ArrayList<Item> findByType(String type) {
       return itemRepository.findByType(type);
    }

    public boolean updateDisplay(ItemRequest request) {
        Optional<Item> entityFromDB = itemRepository.findById(request.getId());

        if (entityFromDB.isEmpty()) return false;

        Display displayFromDb = (Display)entityFromDB.get();
        displayFromDb.setDiagonal(request.getDiagonal());
        displayFromDb.setPrice(request.getPrice());
        displayFromDb.setProducer(request.getProducer());
        displayFromDb.setCountOnStore(request.getCountOnStore());

        itemRepository.save(displayFromDb);

        return true;
    }

    public boolean updatePc(ItemRequest request) {
        Optional<Item> entityFromDB = itemRepository.findById(request.getId());

        if (entityFromDB.isEmpty()) return false;

        Pc pcFromDb = (Pc)entityFromDB.get();
        pcFromDb.setFormFactor(Pc.FormFactor.valueOf(request.getFormFactor()));
        pcFromDb.setPrice(request.getPrice());
        pcFromDb.setProducer(request.getProducer());
        pcFromDb.setCountOnStore(request.getCountOnStore());

        itemRepository.save(pcFromDb);

        return true;

    }

    public boolean updateLaptop(ItemRequest request) {
        Optional<Item> entityFromDB = itemRepository.findById(request.getId());

        if (entityFromDB.isEmpty()) return false;

        Laptop laptopFromDB = (Laptop)entityFromDB.get();
        laptopFromDB.setSize(request.getLaptopSize());
        laptopFromDB.setPrice(request.getPrice());
        laptopFromDB.setProducer(request.getProducer());
        laptopFromDB.setCountOnStore(request.getCountOnStore());

        itemRepository.save(laptopFromDB);
        return true;

    }

    public boolean updateDisk(ItemRequest request) {
        Optional<Item> entityFromDB = itemRepository.findById(request.getId());

        if (entityFromDB.isEmpty()) return false;

        Disk diskFromDb = (Disk)entityFromDB.get();
        diskFromDb.setCapacity(request.getCapacity());
        diskFromDb.setPrice(request.getPrice());
        diskFromDb.setProducer(request.getProducer());
        diskFromDb.setCountOnStore(request.getCountOnStore());

        itemRepository.save(diskFromDb);
        return true;

    }

    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }


}
