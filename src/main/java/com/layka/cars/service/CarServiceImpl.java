package com.layka.cars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.layka.cars.entities.Car;
import com.layka.cars.entities.Maker;
import com.layka.cars.repos.CarRepository;
import com.layka.cars.repos.MakerRepository;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(Car car) {
        carRepository.delete(car);
    }

    @Override
    public void deleteCarById(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public Car getCar(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> findByCarModel(String carModel) {
        return carRepository.findByCarModel(carModel);
    }

    @Override
    public List<Car> findByCarModelContains(String carModel) {
        return carRepository.findByCarModelContains(carModel);
    }

    @Override
    public List<Car> findByCarModelAndCarPrice(String carModel, Double carPrice) {
        return carRepository.findByCarModelPrice(carModel, carPrice);
    }

    @Override
    public List<Car> findByMaker(Maker maker) {
        return carRepository.findByMaker(maker);
    }

    @Override
    public List<Car> findByMakerIdMak(Long id) {
        return carRepository.findByMakerId(id);
    }

    @Override
    public List<Car> findByOrderByCarModelAsc() {
        return carRepository.findByOrderByCarModelAsc();
    }

    @Override
    public List<Car> sortCarsByModelAndPrice() {
        return carRepository.sortCarsByModelAndPrice();
    }

    @Override
    public Page<Car> getAllCarsPerPage(int page, int size) {
        return carRepository.findAll(PageRequest.of(page, size));
    }

    @Autowired
    MakerRepository makerRepository;

    @Override
    public List<Maker> getAllMakers() {
        return makerRepository.findAll();
    }

}
