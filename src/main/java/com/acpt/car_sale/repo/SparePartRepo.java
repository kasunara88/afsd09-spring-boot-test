package com.acpt.car_sale.repo;

import com.acpt.car_sale.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SparePartRepo extends JpaRepository<Vehicle,Integer> {
}
