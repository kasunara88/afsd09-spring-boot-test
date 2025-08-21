package com.acpt.car_sale.controller;

import com.acpt.car_sale.dto.VehicleDTO;
import com.acpt.car_sale.dto.VehicleWithSparePartsDTO;
import com.acpt.car_sale.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleController {

    VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {

        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<VehicleDTO> saveVehicle(@RequestBody VehicleDTO vehicleDTO) {
       VehicleDTO vehicle = vehicleService.saveVehicle(vehicleDTO);
       return new ResponseEntity<>(vehicle, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAllVehicle(){
        List<VehicleDTO> vehicleDTOList = vehicleService.getVehicles();

        return new ResponseEntity<>(vehicleDTOList,HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VehicleDTO> deleteVehicle(@PathVariable Integer id){

        VehicleDTO delete = vehicleService.deleteVehicle(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleDTO> updateVehicle(@PathVariable Integer id, @RequestBody VehicleDTO vehicleDTO){

        VehicleDTO update = vehicleService.updateVehicle(vehicleDTO);
        return new ResponseEntity<>(update, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable Integer id){
        VehicleDTO getVehicalByID = vehicleService.getVehicleById(id);
        return new ResponseEntity<>(getVehicalByID, HttpStatus.OK);
    }

@GetMapping("/brand/{brand}")
    public ResponseEntity<List<VehicleDTO>> getVehicleByBrand(@PathVariable String brand){
        List<VehicleDTO> getVehiclByBrand = vehicleService.getVehiclesByBrand(brand);
        return new ResponseEntity<>(getVehiclByBrand,HttpStatus.OK);
    }

@PostMapping("/spare")
    public ResponseEntity<VehicleWithSparePartsDTO> saveVehicleWithSpareParts(@RequestBody VehicleWithSparePartsDTO vehicleWithSparePartsDTO){
    VehicleWithSparePartsDTO vehicleWithSparePartsDTO1 = vehicleService.saveVehicleWithSpareParts(vehicleWithSparePartsDTO);
        return new ResponseEntity<>(vehicleWithSparePartsDTO1,HttpStatus.CREATED);
    }
}
