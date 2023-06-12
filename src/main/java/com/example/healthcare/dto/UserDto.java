package com.example.healthcare.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class UserDto {
	private long userId;
	private String password;
	private String name;
	private int age;
	private  String contact_info;
	private String emergency_contact;
	private String bloodGroup;
	private String gender;

}
