package com.smartcity.irrigation.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "schedules")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IrrigationSchedule {
    @Id
    private String id;
    private String zoneId;
    private String startTime; // HH:mm
    private int durationMinutes;
    private List<String> daysOfWeek;
}



