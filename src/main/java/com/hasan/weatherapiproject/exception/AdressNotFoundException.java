package com.hasan.weatherapiproject.exception;

public class AdressNotFoundException extends RuntimeException{
    public AdressNotFoundException(String message) {
        super(message);
    }
}
