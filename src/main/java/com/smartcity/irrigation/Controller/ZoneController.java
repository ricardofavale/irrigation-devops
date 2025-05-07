package com.smartcity.irrigation.Controller;

import com.smartcity.irrigation.models.Zone;
import com.smartcity.irrigation.repository.ZoneRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zones")
@RequiredArgsConstructor
@Validated
public class ZoneController {

    private final ZoneRepository zoneRepository;

    @GetMapping
    public ResponseEntity<List<Zone>> getAllZones() {
        return ResponseEntity.ok(zoneRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Zone> createZone(@Valid @RequestBody Zone zone) {
        Zone savedZone = zoneRepository.save(zone);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedZone); // HTTP 201
    }



    @PutMapping("/{id}")
    public ResponseEntity<Zone> updateZone(@PathVariable String id, @Valid @RequestBody Zone zone) {
        zone.setId(id);
        Zone updated = zoneRepository.save(zone);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZone(@PathVariable String id) {
        zoneRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}





