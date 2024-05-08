package com.layka.cars.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCar;

	@NotNull
	@Size(min = 2, max = 15)
	private String carModel;
	
	@Min(value = 1000)
	@Max(value = 1000000)
	private Double carPrice;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateManufacture;
	@ManyToOne
	private Maker maker;

	public Car() {
		super();
	}

	public Car(String carModel, Double carPrice, Date dateManufacture) {
		super();
		this.carModel = carModel;
		this.carPrice = carPrice;
		this.dateManufacture = dateManufacture;
	}

	public Maker getMaker() {
		return maker;
	}

	public void setMaker(Maker maker) {
		this.maker = maker;
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
		return "Car [idCar=" + idCar + ", carModel=" + carModel + ", carPrice=" + carPrice + ", dateManufacture="
				+ dateManufacture + "]";
	}
}
