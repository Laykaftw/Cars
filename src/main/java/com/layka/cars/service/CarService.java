package com.layka.cars.service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.layka.cars.entities.Car;

public interface CarService {
    Car saveCar(Car car);
    Car updateCar(Car car);
    void deleteCar(Car car);
    void deleteCarById(Long id);
    Car getCar(Long id);
    List<Car> getAllCars();
    Page<Car> getAllCarsPerPage(int page, int size);
}
