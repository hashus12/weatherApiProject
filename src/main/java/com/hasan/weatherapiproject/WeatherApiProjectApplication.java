package com.hasan.weatherapiproject;

import com.hasan.weatherapiproject.exception.RestTemplateResponseErrorHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class WeatherApiProjectApplication {

    private final RestTemplateResponseErrorHandler responseErrorHandler;

    public WeatherApiProjectApplication(RestTemplateResponseErrorHandler responseErrorHandler) {
        this.responseErrorHandler = responseErrorHandler;
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplateBuilder()
            .errorHandler(responseErrorHandler)
            .build();
    }

    @Bean
    public HttpHeaders httpHeaders(){
        return new HttpHeaders();
    }

    public static void main(String[] args) {
        SpringApplication.run(WeatherApiProjectApplication.class, args);
    }

}
