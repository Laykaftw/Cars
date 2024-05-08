package com.layka.cars.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "car", types = { Car.class })
public interface CarProjection {
    String getCarModel();
}
