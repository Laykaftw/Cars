package com.layka.cars;

import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.layka.cars.entities.Car;
import com.layka.cars.entities.Maker;
import com.layka.cars.repos.CarRepository;
import com.layka.cars.service.CarService;

@SpringBootTest
class CarsApplicationTests {

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private CarService carService;

	@Test
	public void testCreateCar() {
		Car car = new Car("Toyota Corolla", 25000.0, new Date());
		carRepository.save(car);
	}

	@Test
	public void testFindCar() {
		Car car = carRepository.findById(1L).orElse(null);
		System.out.println(car);
	}

	@Test
	public void testUpdateCar() {
		Car car = carRepository.findById(1L).orElse(null);
		if (car != null) {
			car.setCarPrice(1000.0);
			carRepository.save(car);
		}
	}

	@Test
	public void testDeleteCar() {
		carRepository.deleteById(1L);
	}

	@Test
	public void testListAllCars() {
		List<Car> cars = carRepository.findAll();
		for (Car car : cars) {
			System.out.println(car);
		}
	}

//	@Test
//	public void testFindByCarModelContains() {
//		Page<Car> cars = carService.getAllCarsPerPage(0, 2);
//		System.out.println(cars.getSize());
//		System.out.println(cars.getTotalElements());
//		System.out.println(cars.getTotalPages());
//		cars.getContent().forEach(car -> {
//			System.out.println(car.toString());
//		});
//	}

	@Test
	public void testFindByCarModel() {
		List<Car> cars = carRepository.findByCarModel("E46 M3");
		for (Car car : cars) {
			System.out.println(car);
		}
	}

	@Test
	public void testFindByCarModelContains() {
		List<Car> cars = carRepository.findByCarModelContains("GTR");
		for (Car car : cars) {
			System.out.println(car);
		}
	}

	@Test
	public void testFindByMaker() {
	    Maker maker = new Maker();
	    maker.setId(1L);
	    List<Car> cars = carRepository.findByMaker(maker);
	    for (Car car : cars) {
	        System.out.println(car);
	    }
	}
	
	@Test
    public void findByMakerId() {
        List<Car> cars = carRepository.findByMakerId(1L);
        for (Car car : cars) {
            System.out.println(car);
        }
    }
	@Test
    public void testFindByOrderByCarModelAsc() {
        List<Car> cars = carRepository.findByOrderByCarModelAsc();
        for (Car car : cars) {
            System.out.println(car);
        }
    }
	@Test
	public void testTrierCarsParModeleEtPrix() {
	    List<Car> cars = carRepository.sortCarsByModelAndPrice();
	    for (Car car : cars) {
	        System.out.println(car);
	    }
	}
}
