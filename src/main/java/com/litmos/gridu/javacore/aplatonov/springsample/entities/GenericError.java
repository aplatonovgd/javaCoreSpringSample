package com.litmos.gridu.javacore.aplatonov.springsample.entities;

import org.springframework.stereotype.Component;

public class GenericError {

    private String errorMessage;

    public GenericError(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }

    public void setMessage(String message) {
        this.errorMessage = errorMessage;
    }

}
