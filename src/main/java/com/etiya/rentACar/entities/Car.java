package com.etiya.rentACar.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="dailyPrice")
    private double dailyPrice;

    @Column(name="description")
    private String description;

    @Column(name="modelYear")
    private double modelYear;

    @ManyToOne
    @JoinColumn(name="color_id")
    private Color color;

    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "car")
    private List<Damage> damage;


}