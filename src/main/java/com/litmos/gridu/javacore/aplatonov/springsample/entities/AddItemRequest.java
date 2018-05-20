package com.litmos.gridu.javacore.aplatonov.springsample.entities;


import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class AddItemRequest {

    @Positive
    @NotNull
    private int id;

    @Positive
    @NotNull
    private int quantity;

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

}
