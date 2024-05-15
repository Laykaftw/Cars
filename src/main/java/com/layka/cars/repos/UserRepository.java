package com.layka.cars.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.layka.cars.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}