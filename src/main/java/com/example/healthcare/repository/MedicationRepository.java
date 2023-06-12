package com.example.healthcare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.healthcare.entity.Medication;


public interface MedicationRepository extends JpaRepository<Medication,Long> {

	// Optional<Medication> findById(Long medicationId);
	// Optional<Medication> findById(Long id);
}
