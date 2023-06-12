package com.example.healthcare.service;

import java.util.List;

import com.example.healthcare.dto.HealthRecordDto;

public interface HealthRecordService {
HealthRecordDto getHealthRecordById(Long recordId);
    
    List<HealthRecordDto> getAllHealthRecords();
    
    List<HealthRecordDto> getHealthRecordsForUser(Long userId);
    
    List<HealthRecordDto> getHealthRecordsForOlderWomen();
    
    HealthRecordDto createHealthRecord(HealthRecordDto healthRecordDto);
    
    HealthRecordDto updateHealthRecord(Long recordId, HealthRecordDto healthRecordDto);
    
    void deleteHealthRecord(Long recordId);

}
