package com.acpt.car_sale.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String brand;
    private String model;
    private double engineCapacity;
    private int noOfGears;

    public Vehicle(Integer id, String brand, String model, double engineCapacity, int noOfGears) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.engineCapacity = engineCapacity;
        this.noOfGears = noOfGears;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicle")
    List<SpareParts> spareParts;

}


