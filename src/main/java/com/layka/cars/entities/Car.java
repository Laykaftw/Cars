package com.layka.cars.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCar;
    private String carModel;
    private Double carPrice;
    private Date dateManufacture;

    public Car() {
        super();
    }

    public Car(String carModel, Double carPrice, Date dateManufacture) {
        super();
        this.carModel = carModel;
        this.carPrice = carPrice;
        this.dateManufacture = dateManufacture;
    }

    public Long getIdCar() {
        return idCar;
    }

    public void setIdCar(Long idCar) {
        this.idCar = idCar;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Double carPrice) {
        this.carPrice = carPrice;
    }

    public Date getDateManufacture() {
        return dateManufacture;
    }

    public void setDateManufacture(Date dateManufacture) {
        this.dateManufacture = dateManufacture;
    }

    @Override
    public String toString() {
        return "Car [idCar=" + idCar + ", carModel=" + carModel + ", carPrice=" + carPrice
                + ", dateManufacture=" + dateManufacture + "]";
    }
}
