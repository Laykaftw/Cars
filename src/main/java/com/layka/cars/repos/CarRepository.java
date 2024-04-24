package com.layka.cars.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.layka.cars.entities.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
	
}
