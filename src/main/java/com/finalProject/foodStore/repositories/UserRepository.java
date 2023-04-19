package com.finalProject.foodStore.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalProject.foodStore.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByEmail(String email);
}
