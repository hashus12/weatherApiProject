package com.hasan.weatherapiproject.model;

import lombok.Data;

import java.util.List;
import java.util.TimeZone;

@Data
public class WeatherReport {
    Double latitude;
    Double longitude;
    String resolvedAddress;
    String address;
    TimeZone timezone;
    List<Days> days;
}
