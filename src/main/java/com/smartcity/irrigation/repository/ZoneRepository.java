package com.smartcity.irrigation.repository;

import com.smartcity.irrigation.models.Zone;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ZoneRepository extends MongoRepository<Zone, String> {}
