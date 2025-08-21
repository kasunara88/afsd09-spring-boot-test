package com.acpt.car_sale.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleWithSparePartsDTO {
    private String brand;
    private String model;
    private double engineCapacity;
    private int noOfGears;
    List<SparePartsDTO> sparePartsDTOList;
}
