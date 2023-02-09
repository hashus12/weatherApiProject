package com.hasan.weatherapiproject.entity;

import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

@Data
public class Days {
    Date datetime;
    String conditions;
    String description;
}
