package com.acpt.car_sale.repo;

import com.acpt.car_sale.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleRepo extends JpaRepository<Vehicle,Integer> {
    List<Vehicle> findByBrand(String brand);
    List<Vehicle> findByBrandAndModel(String brand, String model);

}
