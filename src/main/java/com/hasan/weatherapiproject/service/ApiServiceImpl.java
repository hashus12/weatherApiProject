package com.hasan.weatherapiproject.service;

import com.hasan.weatherapiproject.entity.WeatherReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService{

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;

    private static final String WEATHERREPORT_API="https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";
//    https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/Turkey/today?unitGroup=metric&key=KF4AZ4JR9YZ77SP25DV95UXLS&contentType=json

    @Override
    public WeatherReport getWeatherReport(String adress, String time) {
        String resultUrl = WEATHERREPORT_API.concat(adress+"/"+time +"?unitGroup=metric&key=KF4AZ4JR9YZ77SP25DV95UXLS&contentType=json");
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);


        ResponseEntity<WeatherReport> response = restTemplate.exchange(resultUrl, HttpMethod.GET, entity, WeatherReport.class);
        return response.getBody();
    }

}
