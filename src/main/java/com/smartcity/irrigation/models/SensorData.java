package com.smartcity.irrigation.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "sensor_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SensorData {
    @Id
    private String id;
    private String zoneId;
    private LocalDateTime timestamp;
    private int humidity;
    private boolean rainForecast;
}
