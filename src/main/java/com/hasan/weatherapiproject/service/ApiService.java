package com.hasan.weatherapiproject.service;

import com.hasan.weatherapiproject.dto.WeatherReportDto;
import com.hasan.weatherapiproject.model.WeatherReport;

import java.util.Optional;

public interface ApiService {
    public WeatherReportDto getWeatherReport(String adress, String time);
}
