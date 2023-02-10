package com.hasan.weatherapiproject.dto.converter;

import com.hasan.weatherapiproject.dto.WeatherReportDto;
import com.hasan.weatherapiproject.model.WeatherReport;
import org.springframework.stereotype.Component;

@Component
public class WeatherReportDtoConverter {
    public WeatherReportDto convert(WeatherReport from){
        return new WeatherReportDto(from.getLatitude(), from.getLongitude(), from.getResolvedAddress(), from.getAddress(), from.getTimezone(),from.getDays());
    }
}
