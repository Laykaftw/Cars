package com.layka.cars.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.layka.cars.entities.Car;
import com.layka.cars.service.CarService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class CarRESTController {
    
    @Autowired
    private CarService carService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Car getCarById(@PathVariable("id") Long id) {
        return carService.getCar(id);
    }
    @RequestMapping(method = RequestMethod.POST)
    public Car createCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }
    @RequestMapping(method = RequestMethod.PUT)
    public Car updateCar(@RequestBody Car car) {
        return carService.updateCar(car);
    }
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable("id") Long id) {
        carService.deleteCarById(id);
    }
    @GetMapping("/CarsbyMaker/{id}")
    public List<Car> getCarsByMakerId(@PathVariable("id") Long id) {
        return carService.findByMakerIdMak(id);
    }
}
