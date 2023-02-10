package com.hasan.weatherapiproject.service;

import com.hasan.weatherapiproject.dto.WeatherReportDto;

public interface ApiService {
    WeatherReportDto getWeatherReport(String adress, String time);
}
