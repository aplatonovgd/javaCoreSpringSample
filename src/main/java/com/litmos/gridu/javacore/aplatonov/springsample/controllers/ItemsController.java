package com.litmos.gridu.javacore.aplatonov.springsample.controllers;

import com.litmos.gridu.javacore.aplatonov.springsample.entities.GenericError;
import com.litmos.gridu.javacore.aplatonov.springsample.entities.Item;
import com.litmos.gridu.javacore.aplatonov.springsample.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Iterator;

@RestController
public class ItemsController {

    @Autowired
    private ItemRepository itemRepository;


    @PostMapping(path = "/addItemToShop")
    public ResponseEntity addNewItem (@Valid @RequestBody Item item) {

        Iterable<Item> items = itemRepository.findAll();
        Iterator<Item> itemIterator = items.iterator();
        while (itemIterator.hasNext()){
         if(itemIterator.next().getTitle().equals(item.getTitle())){
             return new ResponseEntity(new GenericError("Item already exist"),HttpStatus.CONFLICT);
         }
        }
        itemRepository.save(item);
        return new ResponseEntity(HttpStatus.OK);
    }



    @GetMapping(path = "/showShopItems")
    public ResponseEntity shopItems (){

        return new ResponseEntity(itemRepository.findAll(),HttpStatus.OK);
    }

}
