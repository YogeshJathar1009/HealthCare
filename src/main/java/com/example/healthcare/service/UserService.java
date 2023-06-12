package com.example.healthcare.service;

import java.util.List;

import com.example.healthcare.dto.UserDto;

public interface UserService {

	UserDto getUserById(Long userId);
    UserDto saveUser(UserDto user);
    List<UserDto> getAllUsers();
    void deleteUser(Long userId);
    List<UserDto> searchUsersByName(String name);
    UserDto updateUser(UserDto user,Long userId);
}
