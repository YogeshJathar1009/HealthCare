package com.example.healthcare.serviceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.healthcare.dto.ReminderDto;
import com.example.healthcare.entity.Medication;
import com.example.healthcare.entity.Reminder;
import com.example.healthcare.entity.User;
import com.example.healthcare.exception.ResourceNotFoundException;
import com.example.healthcare.repository.MedicationRepository;
import com.example.healthcare.repository.ReminderRepository;
import com.example.healthcare.repository.UserRepository;
import com.example.healthcare.service.ReminderService;
@Service
public class ReminderServiceImpl implements ReminderService {
	@Autowired
	private ReminderRepository reminderRepository;
   @Autowired
	private ModelMapper modelMapper;
   @Autowired
	private UserRepository userRepository;
   @Autowired
	private MedicationRepository medicationRepository;
   
   
	
	
	 @Override
	    public ReminderDto createReminder(ReminderDto reminderDto) {
	        Reminder reminder = modelMapper.map(reminderDto, Reminder.class);
	        Reminder savedReminder = reminderRepository.save(reminder);
	        return modelMapper.map(savedReminder, ReminderDto.class);
	    }

	    @Override
	    public ReminderDto updateReminder(ReminderDto reminderDto) {
	        Reminder reminder = modelMapper.map(reminderDto, Reminder.class);
	        Reminder updatedReminder = reminderRepository.save(reminder);
	        return modelMapper.map(updatedReminder, ReminderDto.class);
	    }

	    @Override
	    public void deleteReminder(Long reminderId) {
	        reminderRepository.deleteById(reminderId);
	    }

	    @Override
	    public List<ReminderDto> getRemindersForUser(Long userId) {
	        User user = userRepository.findById(userId)
	                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

	        List<Reminder> reminders = reminderRepository.findByUser(user);
	        return reminders.stream()
	                .map(reminder -> modelMapper.map(reminder, ReminderDto.class))
	                .collect(Collectors.toList());
	    }
	    @Override
	    public List<ReminderDto> getRemindersForMedication(Long medicationId) {
	        Medication medication = medicationRepository.findById(medicationId)
	                .orElseThrow(() -> new ResourceNotFoundException("Medication", "id", medicationId));

	        List<Reminder> reminders = reminderRepository.findByMedication(medication);
	        return reminders.stream()
	                .map(reminder -> modelMapper.map(reminder, ReminderDto.class))
	                .collect(Collectors.toList());
	    }
	}

