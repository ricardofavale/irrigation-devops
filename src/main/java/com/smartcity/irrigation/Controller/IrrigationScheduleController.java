package com.smartcity.irrigation.Controller;

import com.smartcity.irrigation.models.IrrigationSchedule;
import com.smartcity.irrigation.repository.IrrigationScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class IrrigationScheduleController {

    private final IrrigationScheduleRepository scheduleRepository;

    @GetMapping
    public List<IrrigationSchedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    @PostMapping
    public IrrigationSchedule createSchedule(@RequestBody IrrigationSchedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @PutMapping("/{id}")
    public IrrigationSchedule updateSchedule(@PathVariable String id, @RequestBody IrrigationSchedule schedule) {
        schedule.setId(id);
        return scheduleRepository.save(schedule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable String id) {
        scheduleRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
