package com.smartcity.irrigation.Controller;

import com.smartcity.irrigation.models.SensorData;
import com.smartcity.irrigation.repository.SensorDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/sensor-data")
@RequiredArgsConstructor
public class SensorDataController {

    private final SensorDataRepository sensorRepository;

    @GetMapping
    public List<SensorData> getAllSensorData() {
        return sensorRepository.findAll();
    }

    @PostMapping
    public SensorData createSensorData(@RequestBody SensorData data) {
        data.setTimestamp(LocalDateTime.now());
        return sensorRepository.save(data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSensorData(@PathVariable String id) {
        sensorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


