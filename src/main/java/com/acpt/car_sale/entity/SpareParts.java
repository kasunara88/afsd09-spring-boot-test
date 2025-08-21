package com.acpt.car_sale.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpareParts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name;
    double price;

    public SpareParts(String name, double price, Vehicle vehicle) {
        this.name = name;
        this.price = price;
        this.vehicle = vehicle;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    Vehicle vehicle;
}
