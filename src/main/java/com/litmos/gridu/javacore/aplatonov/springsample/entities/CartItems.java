package com.litmos.gridu.javacore.aplatonov.springsample.entities;

import javassist.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CartItems {

    private Set<Item> cartInfo = new HashSet<>();

    public Set<Item> getCart() {
        return cartInfo;
    }

    public void addItem(Item item){

        if (cartInfo.contains(item)){
            Optional<Item> optionalItem = cartInfo.stream().filter(i -> i.getId() == item.getId()).findFirst();
            if(optionalItem.isPresent()){
                item.setQuantity(optionalItem.get().getQuantity() + item.getQuantity());
            }
            cartInfo.remove(item);
        }

        cartInfo.add(item);
    }

    public void removeItem(int id) throws NotFoundException {
        Iterator<Item> cartItemsIterator = cartInfo.iterator();

        while (cartItemsIterator.hasNext()){
            Item carItem = cartItemsIterator.next();
            if (carItem.getId() == id){
                cartInfo.remove(carItem);
                return;
            }
        }

        throw new NotFoundException("Element not found");
    }

}
