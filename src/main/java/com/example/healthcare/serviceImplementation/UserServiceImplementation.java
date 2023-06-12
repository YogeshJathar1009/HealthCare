package com.example.healthcare.serviceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.healthcare.dto.UserDto;
import com.example.healthcare.entity.User;
import com.example.healthcare.repository.UserRepository;
import com.example.healthcare.service.UserService;
import com.example.healthcare.exception.ResourceNotFoundException;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	private UserRepository userRepository;
   @Autowired
	private ModelMapper modelMapper;
//   @Autowired
//	private PasswordEncoder passwordEncoder;
   @Override
   public UserDto getUserById(Long userId) {
	   User user=this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		return this.userToDto(user);
   }

   @Override
   public UserDto saveUser(UserDto user) {
       // Map UserDto to User entity
       User userEntity = modelMapper.map(user, User.class);

       // Save the user entity to the database
       User savedUser = userRepository.save(userEntity);

       // Map the saved User entity back to UserDto
       UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);

       return savedUserDto;
   }

   @Override
   public List<UserDto> getAllUsers() {
	   List<User> users =this.userRepository.findAll();
		
		List<UserDto> userDtos=users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
   }

   @Override
   public void deleteUser(Long userId) {
	   User user=this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));	
		this.userRepository.delete(user);
   }
   
   public UserDto updateUser(UserDto userDto, Long userId) {
		
		
		User user=this.userRepository.findById(userId).orElseThrow();
		
		user.setPassword(userDto.getPassword());
		user.setName(userDto.getName());
		user.setAge(userDto.getAge());
		user.setContact_info(userDto.getContact_info());
		user.setEmergency_contact(userDto.getEmergency_contact());
		user.setBloodGroup(userDto.getBloodGroup());
		
		User upadateUser =this.userRepository.save(user);
		UserDto userDto1 =this.userToDto(upadateUser);
		
		return userDto1;
	}

   @Override
   public List<UserDto> searchUsersByName(String name) {
       List<User> users = userRepository.findByNameContaining(name);
       return users.stream()
               .map(user -> modelMapper.map(user, UserDto.class))
               .collect(Collectors.toList());
   }
	public User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		return user;
	}
	public UserDto userToDto(User user) {
		UserDto userDto =this.modelMapper.map(user, UserDto.class);
		return userDto;
	}

}
