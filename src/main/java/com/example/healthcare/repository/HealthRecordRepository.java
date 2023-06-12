package com.example.healthcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.healthcare.entity.HealthRecord;
import com.example.healthcare.entity.User;


public interface HealthRecordRepository extends JpaRepository<HealthRecord,Long> {
	
	List<HealthRecord> findByUser(User user);
}
