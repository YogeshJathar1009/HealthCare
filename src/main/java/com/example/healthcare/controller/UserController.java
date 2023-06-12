package com.example.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.healthcare.dto.ApiResponse;
import com.example.healthcare.dto.UserDto;
import com.example.healthcare.service.UserService;


@RestController
@CrossOrigin
@RequestMapping("api/users")
public class UserController {
	@Autowired
	private UserService userService;
	

//	@PostMapping
//	public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto){
//		UserDto saveUserDto =this.userService.saveUser(userDto);
//	return new ResponseEntity<>(saveUserDto,HttpStatus.CREATED);	
//	}
	@PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto savedUser = userService.saveUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
//	
     
	@GetMapping
	public ResponseEntity<List<UserDto>>getAllUsers(){
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable("id") Long userId){
		return  ResponseEntity.ok(this.userService.getUserById(userId));
	}
	
	@PutMapping("/{id}")
     public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,@RequestBody UserDto userDto){
		UserDto updatedUser=this.userService.updateUser(userDto,userId);
		
		return  ResponseEntity.ok(updatedUser);
	}
	
		@DeleteMapping("/{id}")
	     public ResponseEntity<ApiResponse> deleteUser(@PathVariable("id") Long userId){
			
			this.userService.deleteUser(userId);
			
			return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted sucessfully",true), HttpStatus.OK);
		
		}
		 @GetMapping("/name")
		    public List<UserDto> searchUsersByName(@RequestParam String name) {
		        return userService.searchUsersByName(name);
		    }
	
}
