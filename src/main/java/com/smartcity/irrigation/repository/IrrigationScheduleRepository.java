package com.smartcity.irrigation.repository;

import com.smartcity.irrigation.models.IrrigationSchedule;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IrrigationScheduleRepository extends MongoRepository<IrrigationSchedule, String> {}
