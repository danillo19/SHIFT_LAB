package com.example.demo.repository;

import com.example.demo.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;


public interface ItemRepository extends JpaRepository<Item,Long> {
    Optional<Item> findById(Long id);

    ArrayList<Item> findByType(String type);
}
