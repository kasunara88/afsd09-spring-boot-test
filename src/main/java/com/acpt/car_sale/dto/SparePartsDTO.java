package com.acpt.car_sale.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SparePartsDTO {
    private Integer id;
    private String name;
    private double price;
}
