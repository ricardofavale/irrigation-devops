package com.smartcity.irrigation.repository;

import com.smartcity.irrigation.models.SensorData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SensorDataRepository extends MongoRepository<SensorData, String> {}
