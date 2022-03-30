package com.etiya.rentACar.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "carId")
	private int id;

	@Column(name = "dailyPrice")
	private double dailyPrice;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "modelYear")
	private int modelYear;

	@Column(name = "car_state")
	private CarStates carState;
	
	@ManyToOne
	@JoinColumn(name = "colorId")//renk id ye göre yapar
	private Color color;
	
	@ManyToOne //diğerlerine bağlama
	@JoinColumn(name="brandId")
	private Brand brand;
	
	
	@OneToMany(mappedBy = "car")
	private List<CarDamage> cardamages;
	
	
	@OneToMany(mappedBy = "car")
    private List<CarMaintenance> carMaintanances;
	
	@OneToMany(mappedBy = "car")
	private List<CarRental> carRentals;

}
