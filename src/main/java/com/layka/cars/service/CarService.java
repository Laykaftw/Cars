package com.layka.cars.service;

import java.util.List;

import org.springframework.data.domain.Page;

//import org.springframework.data.domain.Page;
import com.layka.cars.entities.Car;
import com.layka.cars.entities.Maker;

public interface CarService {
    Car saveCar(Car car);
    Car updateCar(Car car);
    void deleteCar(Car car);
    void deleteCarById(Long id);
    Car getCar(Long id);
    List<Car> getAllCars();
    List<Car> findByCarModel(String carModel);
    List<Car> findByCarModelContains(String carModel);
    List<Car> findByCarModelAndCarPrice(String carModel, Double carPrice);
    List<Car> findByMaker(Maker maker);
    List<Car> findByMakerIdMak(Long id);
    List<Car> findByOrderByCarModelAsc();
    List<Car> sortCarsByModelAndPrice();
	Page<Car> getAllCarsPerPage(int page, int size);
}
