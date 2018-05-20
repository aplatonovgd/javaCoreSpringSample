package com.litmos.gridu.javacore.aplatonov.springsample.repository;

import com.litmos.gridu.javacore.aplatonov.springsample.entities.Item;
import com.litmos.gridu.javacore.aplatonov.springsample.exceptions.IncorrectQuantityException;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.repository.CrudRepository;

import java.util.Iterator;


public interface ItemRepository extends CrudRepository<Item,Long> {

    default <T extends Item> void removeItemFromCart(T item) throws IncorrectQuantityException {

        Iterator<T> itemInerator = (Iterator<T>) findAll().iterator();

        while (itemInerator.hasNext()){
            T currentItem = itemInerator.next();

            if (currentItem.getId() == item.getId()){
                if(item.getQuantity() > currentItem.getQuantity()){
                    throw new IncorrectQuantityException("Incorrect quantity");
                }
                else {
                    currentItem.setQuantity(currentItem.getQuantity() - item.getQuantity());
                    save(currentItem);
                }
            }

        }

    }

}
