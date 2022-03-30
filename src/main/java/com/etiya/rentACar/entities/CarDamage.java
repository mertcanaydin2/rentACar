package com.etiya.rentACar.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "car_damages")
public class CarDamage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "damageId")
	private int id;
	
	@Column(name = "accidentDate")
	private LocalDate accidentDate;
	
	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "carId")
	private Car car;
}