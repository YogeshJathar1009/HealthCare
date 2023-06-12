package com.example.healthcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.healthcare.entity.Medication;
import com.example.healthcare.entity.Reminder;
import com.example.healthcare.entity.User;

public interface ReminderRepository extends JpaRepository<Reminder,Long> {
    

List<Reminder> findByUser(User user);
    
List<Reminder> findByMedication(Medication medication);
}
