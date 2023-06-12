package com.example.healthcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.healthcare.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

	List<User> findByNameContaining(String name);

}
