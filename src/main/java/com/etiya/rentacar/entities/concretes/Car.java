package com.etiya.rentacar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="dailyPrice")
    private double dailyPrice;
    @Column(name="modelYear")
    private int modelYear;
    @Column(name="description")
    private String description;
    @Column(name="state") //1 - Available 2 - Under Maintenance 3 - Rented
    private int state;
    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brand;
    @ManyToOne
    @JoinColumn(name="color_id")
    private Color color;
    @ManyToOne
    @JoinColumn(name="rental_id")
    private Rental rental;
    @ManyToOne
    @JoinColumn(name="fuel_id")
    private Fuel fuel;
    @ManyToOne
    @JoinColumn(name="transformation_id")
    private Transformation transformation;
    @ManyToOne
    @JoinColumn(name="maintenance_id")
    private Maintenance maintenance;
}
