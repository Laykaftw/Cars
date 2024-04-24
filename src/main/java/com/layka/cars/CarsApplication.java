package com.layka.cars;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.layka.cars.entities.Car;
import com.layka.cars.service.CarService;

@SpringBootApplication
public class CarsApplication implements CommandLineRunner {

    @Autowired
    private CarService carService;

    public static void main(String[] args) {
        SpringApplication.run(CarsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    	carService.saveCar(new Car("BMW M3 (E46)", 40000.0, new Date())); 
        carService.saveCar(new Car("Nissan GT-R", 95000.0, new Date())); 
        carService.saveCar(new Car("Audi R8", 120000.0, new Date())); 
    }
}
