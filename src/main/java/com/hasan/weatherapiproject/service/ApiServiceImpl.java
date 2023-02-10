package com.hasan.weatherapiproject.service;

import com.hasan.weatherapiproject.dto.WeatherReportDto;
import com.hasan.weatherapiproject.dto.converter.WeatherReportDtoConverter;
import com.hasan.weatherapiproject.model.WeatherReport;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class ApiServiceImpl implements ApiService{

    private final RestTemplate restTemplate;

    private final HttpHeaders httpHeaders;
    private final WeatherReportDtoConverter converter;

    private static final String WEATHERREPORT_API="https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";

    public ApiServiceImpl(RestTemplate restTemplate, HttpHeaders httpHeaders, WeatherReportDtoConverter converter) {
        this.restTemplate = restTemplate;
        this.httpHeaders = httpHeaders;
        this.converter = converter;
    }
//    https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/Turkey/today?unitGroup=metric&key=KF4AZ4JR9YZ77SP25DV95UXLS&contentType=json

    @Override
    public WeatherReportDto getWeatherReport(String adress, String time) {
        if (adress.isEmpty() || adress.trim().length() == 0) {
            throw new IllegalArgumentException("adress cannot be empty");
        }
        if (time.isEmpty() || time.trim().length() == 0) {
            throw new IllegalArgumentException("time cannot be empty");
        }
        String resultApi = WEATHERREPORT_API.concat(adress+"/"+time +"?unitGroup=metric&key=KF4AZ4JR9YZ77SP25DV95UXLS&contentType=json");
//        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

//        ResponseEntity<WeatherReport> response = restTemplate.exchange(resultApi, HttpMethod.GET, entity, WeatherReport.class);
        WeatherReport weatherReport = restTemplate.getForObject(resultApi,WeatherReport.class);
//        return response.getBody();
          return converter.convert(weatherReport);
    }

}
