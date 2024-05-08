package com.layka.cars.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.layka.cars.entities.Maker;

public interface MakerRepository extends JpaRepository<Maker, Long> {

}
