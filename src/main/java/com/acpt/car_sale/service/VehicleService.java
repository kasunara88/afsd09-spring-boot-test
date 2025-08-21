package com.acpt.car_sale.service;

import com.acpt.car_sale.dto.SparePartsDTO;
import com.acpt.car_sale.dto.VehicleDTO;
import com.acpt.car_sale.dto.VehicleWithSparePartsDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {
    VehicleDTO saveVehicle(VehicleDTO vehicleDTO);
    VehicleDTO updateVehicle(VehicleDTO vehicleDTO);
    VehicleDTO deleteVehicle(int id);
    List<VehicleDTO> getVehicles();
    VehicleDTO getVehicleById(int id);
    List<VehicleDTO> getVehiclesByBrand(String brand);
    VehicleWithSparePartsDTO saveVehicleWithSpareParts(VehicleWithSparePartsDTO vehicleWithSparePartsDTO);
}
