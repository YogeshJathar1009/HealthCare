package com.example.healthcare.controller;

import java.util.List;

import com.example.healthcare.dto.HealthRecordDto;
import com.example.healthcare.service.HealthRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/health-records")
public class HealthRecordController {
	@Autowired
    private  HealthRecordService healthRecordService;

    @GetMapping("/{recordId}")
    public ResponseEntity<HealthRecordDto> getHealthRecordById(@PathVariable("recordId") Long recordId) {
        HealthRecordDto healthRecordDto = healthRecordService.getHealthRecordById(recordId);
        return ResponseEntity.ok(healthRecordDto);
    }

    @GetMapping
    public ResponseEntity<List<HealthRecordDto>> getAllHealthRecords() {
        List<HealthRecordDto> healthRecordDtos = healthRecordService.getAllHealthRecords();
        return ResponseEntity.ok(healthRecordDtos);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<HealthRecordDto>> getHealthRecordsForUser(@PathVariable("userId") Long userId) {
        List<HealthRecordDto> healthRecordDtos = healthRecordService.getHealthRecordsForUser(userId);
        return ResponseEntity.ok(healthRecordDtos);
    }

    @GetMapping("/older-women")
    public ResponseEntity<List<HealthRecordDto>> getHealthRecordsForOlderWomen() {
        List<HealthRecordDto> healthRecordDtos = healthRecordService.getHealthRecordsForOlderWomen();
        return ResponseEntity.ok(healthRecordDtos);
    }

    @PostMapping
    public ResponseEntity<HealthRecordDto> createHealthRecord(@RequestBody HealthRecordDto healthRecordDto) {
        HealthRecordDto createdHealthRecordDto = healthRecordService.createHealthRecord(healthRecordDto);
        return new ResponseEntity<>(createdHealthRecordDto, HttpStatus.CREATED);
    }

    @PutMapping("/{recordId}")
    public ResponseEntity<HealthRecordDto> updateHealthRecord(
            @PathVariable("recordId") Long recordId,
            @RequestBody HealthRecordDto healthRecordDto) {
        HealthRecordDto updatedHealthRecordDto = healthRecordService.updateHealthRecord(recordId, healthRecordDto);
        return ResponseEntity.ok(updatedHealthRecordDto);
    }

    @DeleteMapping("/{recordId}")
    public ResponseEntity<Void> deleteHealthRecord(@PathVariable("recordId") Long recordId) {
        healthRecordService.deleteHealthRecord(recordId);
        return ResponseEntity.noContent().build();
    }
}