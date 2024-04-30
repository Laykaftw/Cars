package com.layka.cars.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.layka.cars.entities.Car;
import com.layka.cars.entities.Maker;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByCarModel(String carModel);
    List<Car> findByCarModelContains(String carModel);
    @Query("select c from Car c where c.carModel like %?1 and c.carPrice > ?2")
    List<Car> findByCarModelPrice(String carModel, Double carPrice);
    @Query("select c from Car c where c.maker = ?1")
    List<Car> findByMaker(Maker maker);
    List<Car> findByMakerId(long id);
    List<Car> findByOrderByCarModelAsc();
    @Query("SELECT c FROM Car c ORDER BY c.carModel ASC, c.carPrice DESC")
    List<Car> sortCarsByModelAndPrice();
    
    
    
    
}