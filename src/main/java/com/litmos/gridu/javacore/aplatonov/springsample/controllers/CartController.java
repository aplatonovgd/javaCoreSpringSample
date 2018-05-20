package com.litmos.gridu.javacore.aplatonov.springsample.controllers;

import com.litmos.gridu.javacore.aplatonov.springsample.entities.*;
import com.litmos.gridu.javacore.aplatonov.springsample.exceptions.IncorrectQuantityException;
import com.litmos.gridu.javacore.aplatonov.springsample.repository.ItemRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Iterator;
import java.util.Set;

@RestController
public class CartController {

    @Autowired
    private CartItems cartItems;

    @Autowired
    private ItemRepository itemRepository;

    @PostMapping(path = "/addItemToCart")
    public ResponseEntity addNewItem (@Valid @RequestBody AddItemRequest addItemRequest) {

        Iterable<Item> items = itemRepository.findAll();
        Iterator<Item> itemIterator = items.iterator();

        while (itemIterator.hasNext()){

            Item currentItem = itemIterator.next();

            if(currentItem.getId()== addItemRequest.getId()){
                currentItem.setQuantity(addItemRequest.getQuantity());
                cartItems.addItem(currentItem);
                return new ResponseEntity(HttpStatus.OK);
            }
        }

        return new ResponseEntity(new GenericError("Item not found"),HttpStatus.NOT_FOUND);
    }

    @PostMapping("/removeItemFromCart")
    public ResponseEntity removeItemFromCart(@Valid @RequestBody RemoveItemRequest removeItemRequest){

        try {
            cartItems.removeItem(removeItemRequest.getId());
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (NotFoundException e){
            return new ResponseEntity(new GenericError("Element not found"), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/checkoutCart")
    public ResponseEntity checkoutItems() throws NotFoundException {

        if(cartItems.getCart().size() == 0){
           return new ResponseEntity(new GenericError("Cart is empty"), HttpStatus.CONFLICT);
        }

        Iterator<Item> cartIterator = cartItems.getCart().iterator();
        while (cartIterator.hasNext()){
            Item currentItem = cartIterator.next();
            try {
                itemRepository.removeItemFromCart(currentItem);
            }
            catch (IncorrectQuantityException e){
                new ResponseEntity(new GenericError("Incorrect quantity"), HttpStatus.CONFLICT);
            }
            cartItems.removeItem(currentItem.getId());
        }

        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping(path = "/showCartItems")
    public ResponseEntity showCartItems () {

        return new ResponseEntity(cartItems,HttpStatus.OK);

    }



}
