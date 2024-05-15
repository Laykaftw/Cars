package com.layka.cars.controllers;

import com.layka.cars.entities.Car; 
import com.layka.cars.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        return "listeCars";
    }
    
//    @GetMapping("/accessDenied")
//	public String error() {
//		return "accessDenied";
//	}

    @RequestMapping("/saveCar")
    public String saveCar(@Valid Car car, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "formCar";
        carService.saveCar(car);
        return "redirect:/listeCars";
    }

    @RequestMapping("/deleteCar")
    public String deleteCar(@RequestParam("id") Long id,
                            @RequestParam(name = "page", defaultValue = "0") int page,
                            @RequestParam(name = "size", defaultValue = "2") int size) {
        carService.deleteCarById(id);
        return "redirect:/listeCars?page=" + page + "&size=" + size;
    }

    @RequestMapping("/editCar")
    public String editCar(@RequestParam("id") Long id, ModelMap modelMap) {
        Car car = carService.getCar(id);
        modelMap.addAttribute("car", car);
        modelMap.addAttribute("mode", "edit");
        return "formCar";
    }
    
    @GetMapping(value = "/")
    public String welcome() {
     return "index";
    }

    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap) {
        modelMap.addAttribute("car", new Car());
        modelMap.addAttribute("mode", "new");
        return "formCar";
    }

    @RequestMapping("/updateCar")
    public String updateCar(@ModelAttribute("car") Car car,
                            @RequestParam("date") String date,
                            @RequestParam(name = "page", defaultValue = "0") int page,
                            @RequestParam(name = "size", defaultValue = "2") int size,
                            ModelMap modelMap) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateManufacture = dateFormat.parse(date);
        car.setDateManufacture(dateManufacture);
        carService.updateCar(car);
        return "redirect:/listeCars?page=" + page + "&size=" + size;
    }
}
