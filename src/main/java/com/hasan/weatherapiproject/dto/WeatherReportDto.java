package com.hasan.weatherapiproject.dto;

import com.hasan.weatherapiproject.model.Days;
import lombok.Data;

import java.util.List;
import java.util.TimeZone;

@Data
public class WeatherReportDto {
    Double latitude;
    Double longitude;
    String resolvedAddress;
    String address;
    TimeZone timezone;
    List<Days> days;

    public WeatherReportDto(Double latitude, Double longitude, String resolvedAddress, String address, TimeZone timezone, List<Days> days) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.resolvedAddress = resolvedAddress;
        this.address = address;
        this.timezone = timezone;
        this.days = days;
    }
}
