package com.hasan.weatherapiproject.controller;

import com.hasan.weatherapiproject.entity.WeatherReport;
import com.hasan.weatherapiproject.service.ApiServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
public class ApiController {

    @Autowired
    private ApiServiceImpl apiService;

    @GetMapping("/{adress}/{time}")
    public ResponseEntity<WeatherReport> getWeatherReport(@PathVariable String adress, @PathVariable String time) {
        System.out.println(adress);
        if (adress == null || adress.trim().length() == 0) {
            throw new IllegalArgumentException("adress cannot be empty");
        }
        if (time == null || time.trim().length() == 0) {
            throw new IllegalArgumentException("time cannot be empty");
        }
        WeatherReport weatherReport = apiService.getWeatherReport(adress,time);
        return new ResponseEntity<>(weatherReport, HttpStatus.OK);
    }

}
