package com.hasan.weatherapiproject.model;

import lombok.Data;

import java.sql.Date;

@Data
public class Days {
    Date datetime;
    String conditions;
    String description;
}
