package com.example.healthcare.serviceImplementation;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.healthcare.dto.HealthRecordDto;
import com.example.healthcare.entity.HealthRecord;
import com.example.healthcare.entity.User;
import com.example.healthcare.exception.ResourceNotFoundException;
import com.example.healthcare.repository.HealthRecordRepository;
import com.example.healthcare.repository.UserRepository;
import com.example.healthcare.service.HealthRecordService;
@Service
public class HealthRecordServiceImplementation implements HealthRecordService {
	@Autowired
    private HealthRecordRepository healthRecordRepository;

    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private UserRepository userRepository;
    

    @Override
    public HealthRecordDto getHealthRecordById(Long recordId) {
        HealthRecord healthRecord = healthRecordRepository.findById(recordId)
                .orElseThrow(() -> new ResourceNotFoundException("Health Record", "id", recordId));
        return modelMapper.map(healthRecord, HealthRecordDto.class);
    }

    @Override
    public List<HealthRecordDto> getAllHealthRecords() {
        List<HealthRecord> healthRecords = healthRecordRepository.findAll();
        return healthRecords.stream()
                .map(healthRecord -> modelMapper.map(healthRecord, HealthRecordDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<HealthRecordDto> getHealthRecordsForUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        List<HealthRecord> healthRecords = healthRecordRepository.findByUser(user);
        return healthRecords.stream()
                .map(healthRecord -> modelMapper.map(healthRecord, HealthRecordDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<HealthRecordDto> getHealthRecordsForOlderWomen() {
        List<HealthRecord> healthRecords = healthRecordRepository.findAll();
        List<HealthRecordDto> healthRecordDtos = new ArrayList<>();

        for (HealthRecord healthRecord : healthRecords) {
            User user = healthRecord.getUser();
            int userAge = user.getAge();
            String userGender = user.getGender();

            if (userAge >= 60 && userGender.equalsIgnoreCase("female")) {
                HealthRecordDto healthRecordDto = modelMapper.map(healthRecord, HealthRecordDto.class);
                healthRecordDtos.add(healthRecordDto);
            }
        }

        return healthRecordDtos;
    }

    @Override
    public HealthRecordDto createHealthRecord(HealthRecordDto healthRecordDto) {
        HealthRecord healthRecord = modelMapper.map(healthRecordDto, HealthRecord.class);
        HealthRecord savedHealthRecord = healthRecordRepository.save(healthRecord);
        return modelMapper.map(savedHealthRecord, HealthRecordDto.class);
    }

    @Override
    public HealthRecordDto updateHealthRecord(Long recordId, HealthRecordDto healthRecordDto) {
        HealthRecord existingHealthRecord = healthRecordRepository.findById(recordId)
                .orElseThrow(() -> new ResourceNotFoundException("Health Record", "id", recordId));

        existingHealthRecord.setDate(healthRecordDto.getDate());
        existingHealthRecord.setBlood_pressure(healthRecordDto.getBlood_pressure());
        existingHealthRecord.setHeart_rate(healthRecordDto.getHeart_rate());
        existingHealthRecord.setWeight(healthRecordDto.getWeight());

        HealthRecord updatedHealthRecord = healthRecordRepository.save(existingHealthRecord);
        return modelMapper.map(updatedHealthRecord, HealthRecordDto.class);
    }

    @Override
    public void deleteHealthRecord(Long recordId) {
        HealthRecord healthRecord = healthRecordRepository.findById(recordId)
                .orElseThrow(() -> new ResourceNotFoundException("Health Record", "id", recordId));
        healthRecordRepository.delete(healthRecord);
    }
}