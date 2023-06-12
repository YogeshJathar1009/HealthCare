package com.example.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.healthcare.dto.ReminderDto;
import com.example.healthcare.service.ReminderService;

@RestController
@RequestMapping("/api/reminders")
public class ReminderController {

    @Autowired
    private ReminderService reminderService;

    @PostMapping
    public ResponseEntity<ReminderDto> createReminder(@RequestBody ReminderDto reminderDto) {
        ReminderDto createdReminder = reminderService.createReminder(reminderDto);
        return new ResponseEntity<>(createdReminder, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ReminderDto> updateReminder(@RequestBody ReminderDto reminderDto) {
        ReminderDto updatedReminder = reminderService.updateReminder(reminderDto);
        return new ResponseEntity<>(updatedReminder, HttpStatus.OK);
    }

    @DeleteMapping("/{reminderId}")
    public ResponseEntity<Void> deleteReminder(@PathVariable("reminderId") Long reminderId) {
        reminderService.deleteReminder(reminderId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{userId}")
    public ResponseEntity<List<ReminderDto>> getRemindersForUser(@PathVariable Long userId) {
        List<ReminderDto> reminders = reminderService.getRemindersForUser(userId);
        return ResponseEntity.ok(reminders);
    }

   @GetMapping("{medicationId}")
   public ResponseEntity<List<ReminderDto>> getRemindersForMedication(@PathVariable Long medicationId) {
       List<ReminderDto> reminders = reminderService.getRemindersForMedication(medicationId);
       return ResponseEntity.ok(reminders);
   }
}