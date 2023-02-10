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

    @GetMapping("/{adress}/{time}")
    public ResponseEntity<WeatherReportDto> getWeatherReport(@PathVariable String adress, @PathVariable String time) {
//        if (adress.isEmpty() || adress.get().trim().length() == 0) {
//            throw new IllegalArgumentException("adress cannot be empty");
//        }
//        if (time.isEmpty() || time.get().trim().length() == 0) {
//            throw new IllegalArgumentException("time cannot be empty");
//        }
        return ResponseEntity.ok(apiService.getWeatherReport(adress,time));
    }

}
