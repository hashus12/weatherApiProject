package com.hasan.weatherapiproject.validator;

import com.hasan.weatherapiproject.exception.AdressTimeNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class ApiValidator {
    // the given address and time parameters are verified.
    public void validate(String adress, String time) {
        if (adress.isEmpty() && !time.isEmpty()) {
            throw new AdressTimeNotFoundException("adress cannot be empty");
        }
        if (time.isEmpty() && !adress.isEmpty()) {
            throw new AdressTimeNotFoundException("time cannot be empty");
        }
        if (time.isEmpty() && adress.isEmpty()) {
            throw new AdressTimeNotFoundException("address and time cannot be empty");
        }
    }
}
