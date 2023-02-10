package com.hasan.weatherapiproject.service;

import com.hasan.weatherapiproject.dto.WeatherReportDto;
import com.hasan.weatherapiproject.dto.converter.WeatherReportDtoConverter;
import com.hasan.weatherapiproject.model.WeatherReport;
import com.hasan.weatherapiproject.validator.ApiValidator;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiServiceImpl implements ApiService {
    private final RestTemplate restTemplate;
    private final WeatherReportDtoConverter converter;
    private final ApiValidator apiValidator;
    //Base api url
    private static final String WEATHERREPORT_API = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";

    public ApiServiceImpl(RestTemplate restTemplate, WeatherReportDtoConverter converter, ApiValidator apiValidator) {
        this.restTemplate = restTemplate;
        this.converter = converter;
        this.apiValidator = apiValidator;
    }

    // The method where we can get a weather report by giving address and time and api url to resttemplate.
    @Override
    public WeatherReportDto getWeatherReport(String adress, String time) {
        apiValidator.validate(adress, time);
        String resultApi = WEATHERREPORT_API.concat(adress + "/" + time + "?unitGroup=metric&key=KF4AZ4JR9YZ77SP25DV95UXLS&contentType=json");
        WeatherReport weatherReport = restTemplate.getForObject(resultApi, WeatherReport.class);
        return converter.convert(weatherReport);
    }

}
