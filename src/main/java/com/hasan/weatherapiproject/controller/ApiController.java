package com.hasan.weatherapiproject.controller;

import com.hasan.weatherapiproject.dto.WeatherReportDto;
import com.hasan.weatherapiproject.service.ApiServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/apis")
public class ApiController {

    private final ApiServiceImpl apiService;

    public ApiController(ApiServiceImpl apiService) {
        this.apiService = apiService;
    }

    //weather report is returned by giving address and time parameters to api url.
    @GetMapping
    public ResponseEntity<WeatherReportDto> getWeatherReport(@RequestParam String adress, @RequestParam String time) {
        return ResponseEntity.ok(apiService.getWeatherReport(adress,time));
    }

}
