package com.smartcity.irrigation.Controller;

import com.smartcity.irrigation.models.Zone;
import com.smartcity.irrigation.repository.ZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zones")
@RequiredArgsConstructor
public class ZoneController {

    private final ZoneRepository zoneRepository;

    @GetMapping
    public List<Zone> getAllZones() {
        return zoneRepository.findAll();
    }

    @PostMapping
    public Zone createZone(@RequestBody Zone zone) {
        return zoneRepository.save(zone);
    }

    @PutMapping("/{id}")
    public Zone updateZone(@PathVariable String id, @RequestBody Zone zone) {
        zone.setId(id);
        return zoneRepository.save(zone);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZone(@PathVariable String id) {
        zoneRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


