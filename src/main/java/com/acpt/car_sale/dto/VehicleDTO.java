package com.acpt.car_sale.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {
    private Integer id;
    private String brand;
    private String model;
    private double engineCapacity;
    private int noOfGears;
}
