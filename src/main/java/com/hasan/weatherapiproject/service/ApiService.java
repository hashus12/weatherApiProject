package com.hasan.weatherapiproject.service;

import com.hasan.weatherapiproject.entity.WeatherReport;

public interface ApiService {
    public WeatherReport getWeatherReport(String adress, String time);
}
