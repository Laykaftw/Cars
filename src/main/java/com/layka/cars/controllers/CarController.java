package com.layka.cars.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.layka.cars.entities.Car;
import com.layka.cars.service.CarService;
import org.springframework.data.domain.Page;

@Controller
public class CarController {
    
    @Autowired
    CarService carService;

    @RequestMapping("/ListeCars")
    public String listCars(ModelMap modelMap,
                           @RequestParam (name="page",defaultValue = "0") int page,
                           @RequestParam (name="size", defaultValue = "2") int size) {
        Page<Car> cars = carService.getAllCarsPerPage(page, size);
        modelMap.addAttribute("cars", cars);
        modelMap.addAttribute("pages", new int[cars.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "ListeCars";
    }

    @RequestMapping("/showCreate")
    public String showCreate() {
        return "createCar";
    }

    @RequestMapping("/saveCar")
    public String saveCar(@ModelAttribute("car") Car car,
                          @RequestParam("date") String date,
                          ModelMap modelMap) throws ParseException {
        // Conversion de la date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateManufacture = dateFormat.parse(date);
        car.setDateManufacture(dateManufacture);

        Car savedCar = carService.saveCar(car);
        String msg = "Car saved with Id " + savedCar.getIdCar();
        modelMap.addAttribute("msg", msg);
        return "createCar";
    }

    @RequestMapping("/deleteCar")
    public String deleteCar(@RequestParam("id") Long id,
                            ModelMap modelMap,
                            @RequestParam(name = "page", defaultValue = "0") int page,
                            @RequestParam(name = "size", defaultValue = "2") int size) {
        carService.deleteCarById(id);
        Page<Car> cars = carService.getAllCarsPerPage(page, size);
        modelMap.addAttribute("cars", cars);
        modelMap.addAttribute("pages", new int[cars.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeCars";
    }


    @RequestMapping("/editCar")
    public String editCar(@RequestParam("id") Long id, ModelMap modelMap) {
        Car car = carService.getCar(id);
        modelMap.addAttribute("car", car);
        return "editCar";
    }

    @RequestMapping("/updateCar")
    public String updateCar(@ModelAttribute("car") Car car,
                            @RequestParam("date") String date,
                            ModelMap modelMap) throws ParseException {
        // Conversion de la date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateManufacture = dateFormat.parse(date);
        car.setDateManufacture(dateManufacture);

        carService.updateCar(car);
        Page<Car> cars = carService.getAllCarsPerPage(0, 2);
        modelMap.addAttribute("cars", cars);
        modelMap.addAttribute("pages", new int[cars.getTotalPages()]);
        modelMap.addAttribute("currentPage", 0);
        return "listeCars";
    }
}
