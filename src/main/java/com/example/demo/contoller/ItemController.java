package com.example.demo.contoller;

import com.example.demo.model.Item;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;


@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;


    @PostMapping("shop/item/create")
    public ResponseEntity createItem(@Valid @RequestBody ItemRequest request) {
        ItemBuilder builder = new ItemBuilder();

        Item item = builder.build(request);

        item.setPrice(request.getPrice());
        item.setProducer(request.getProducer());
        item.setCountOnStore(request.getCountOnStore());
        item.setType(request.getType());

        itemService.saveItem(item);

        return ResponseEntity.ok(HttpStatus.OK);

    }

    public boolean updateSpecificItem(ItemRequest request) {
        switch (request.getType()) {
            case ItemBuilder.PC:
                return itemService.updatePc(request);
            case ItemBuilder.LAPTOP:
                return itemService.updateLaptop(request);
            case ItemBuilder.DISPLAY:
                return itemService.updateDisplay(request);
            case ItemBuilder.DISK:
                return itemService.updateDisk(request);
            default:
                return false;

        }
    }

    @PostMapping("shop/item/update")
    public ResponseEntity updateItem(@Valid @RequestBody ItemRequest request) {

        if (!updateSpecificItem(request)) {
            return new ResponseEntity("No such item for update\n", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity("OK",HttpStatus.OK);

    }

    @GetMapping("shop/item/type/{type}/get")
    public ArrayList<Item> getItemListByType(@PathVariable("type") String type) {
        System.out.println("Type: " + type);

        ArrayList<Item> items = itemService.findByType(type);
        System.out.println("\n");
        System.out.println(items);
        System.out.println("\n");
        return items;
    }

    @GetMapping("shop/item/{id}/get")
    public Item getItemById(@PathVariable("id") Long id) {
        var answer = itemService.findById(id);
        if (answer.isEmpty()) return null;
        return answer.get();
    }

}
