package com.acpt.car_sale.service.impl;

import com.acpt.car_sale.dto.SparePartsDTO;
import com.acpt.car_sale.dto.VehicleDTO;
import com.acpt.car_sale.dto.VehicleWithSparePartsDTO;
import com.acpt.car_sale.entity.SpareParts;
import com.acpt.car_sale.entity.Vehicle;
import com.acpt.car_sale.repo.SparePartRepo;
import com.acpt.car_sale.repo.VehicleRepo;
import com.acpt.car_sale.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {
    VehicleRepo vehicleRepo;
    SparePartRepo sparePartRepo;

    @Autowired
    public VehicleServiceImpl(VehicleRepo vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }

    @Override
    public VehicleDTO saveVehicle(VehicleDTO vehicleDTO) {
        Vehicle save = vehicleRepo.save(new Vehicle(vehicleDTO.getId(), vehicleDTO.getBrand(), vehicleDTO.getModel(),
                vehicleDTO.getEngineCapacity(), vehicleDTO.getNoOfGears()));
        return new VehicleDTO(save.getId(), save.getBrand(), save.getModel(), save.getEngineCapacity(), save.getNoOfGears());
    }

    @Override
    public VehicleDTO updateVehicle(VehicleDTO vehicleDTO) {
        Optional<Vehicle> byId = vehicleRepo.findById(vehicleDTO.getId());

        if (byId.isPresent()) {
            Vehicle vehicle = byId.get();
            vehicle.setBrand(vehicleDTO.getBrand());
            vehicle.setModel(vehicleDTO.getModel());
            vehicle.setEngineCapacity(vehicleDTO.getEngineCapacity());
            vehicle.setNoOfGears(vehicleDTO.getNoOfGears());
            vehicleRepo.save(vehicle);

            return new VehicleDTO(vehicle.getId(), vehicle.getBrand(), vehicle.getModel(), vehicle.getEngineCapacity(), vehicle.getNoOfGears());
        } else {
            return null;
        }
    }

    @Override
    public VehicleDTO deleteVehicle(int id) {

        Optional<Vehicle> byId = vehicleRepo.findById(id);
        if (byId.isPresent()) {
            vehicleRepo.deleteById(id);
            Vehicle vehicle = byId.get();
            return new VehicleDTO(vehicle.getId(), vehicle.getBrand(), vehicle.getModel(), vehicle.getEngineCapacity(), vehicle.getNoOfGears());
        } else {
            return null;
        }
    }

    @Override
    public List<VehicleDTO> getVehicles() {
        List<Vehicle> vehicles = vehicleRepo.findAll();

        List<VehicleDTO> vehicleDTOList = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            VehicleDTO vehicleDTO = new VehicleDTO(vehicle.getId(), vehicle.getBrand(), vehicle.getModel(), vehicle.getEngineCapacity(), vehicle.getNoOfGears());
            vehicleDTOList.add(vehicleDTO);
        }
        return vehicleDTOList;

    }

    @Override
    public VehicleDTO getVehicleById(int id) {

        Optional<Vehicle> byId = vehicleRepo.findById(id);

        if (byId.isPresent()) {
            Vehicle vehicle = byId.get();
            return new VehicleDTO(vehicle.getId(), vehicle.getBrand(), vehicle.getModel(),
                    vehicle.getEngineCapacity(), vehicle.getNoOfGears());
        } else {
            // If the vehicle is not found, return null
            return null;
        }
    }

    @Override
    public List<VehicleDTO> getVehiclesByBrand(String brand) {
        List<Vehicle> byBrand = vehicleRepo.findByBrand(brand);

        List<VehicleDTO> vehicleDTOList = new ArrayList<>();

        for (Vehicle vehicle : byBrand) {
            VehicleDTO vehicleDTO = new VehicleDTO(vehicle.getId(),vehicle.getBrand(), vehicle.getModel(), vehicle.getEngineCapacity(), vehicle.getNoOfGears());
            vehicleDTOList.add(vehicleDTO);
        }
        return vehicleDTOList;
    }

    @Override
    public VehicleWithSparePartsDTO saveVehicleWithSpareParts(VehicleWithSparePartsDTO vwsDto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(vwsDto.getBrand());
        vehicle.setModel(vwsDto.getModel());
        vehicle.setEngineCapacity(vwsDto.getEngineCapacity());
        vehicle.setNoOfGears(vwsDto.getNoOfGears());

        ArrayList<SpareParts> list = new ArrayList<>();
        for(SparePartsDTO sparePartsDTO : vwsDto.getSparePartsDTOList()){
            list.add(new SpareParts(sparePartsDTO.getName(),sparePartsDTO.getPrice(),vehicle));
        }

        vehicle.setSpareParts(list);
        Vehicle saved = vehicleRepo.save(vehicle);

        return new VehicleWithSparePartsDTO(saved.getBrand(), saved.getModel(), saved.getEngineCapacity(), saved.getNoOfGears(),
                saved.getSpareParts().stream().map(sp -> new SparePartsDTO(sp.getId(),sp.getName(),sp.getPrice())).toList());
    }

}
