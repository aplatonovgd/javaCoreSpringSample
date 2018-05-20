package com.litmos.gridu.javacore.aplatonov.springsample.entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class RemoveItemRequest {

    @Positive
    @NotNull
    private int id;

    public int getId() {
        return id;
    }
}

