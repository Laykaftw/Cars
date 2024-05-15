package com.layka.cars.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.layka.cars.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}