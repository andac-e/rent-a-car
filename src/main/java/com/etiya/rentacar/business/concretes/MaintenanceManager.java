package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.MaintenanceService;
import com.etiya.rentacar.business.dtos.requests.maintenances.CreateMaintenanceRequest;
import com.etiya.rentacar.business.dtos.responses.maintenances.CreatedMaintenanceResponse;
import com.etiya.rentacar.business.rules.maintenance.MaintenanceBusinessRules;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataaccess.abstracts.CarRepository;
import com.etiya.rentacar.dataaccess.abstracts.MaintenanceRepository;
import com.etiya.rentacar.entities.concretes.Car;
import com.etiya.rentacar.entities.concretes.Maintenance;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class MaintenanceManager implements MaintenanceService {
    MaintenanceRepository maintenanceRepository;
    ModelMapperService modelMapperService;
    CarRepository carRepository;
    MaintenanceBusinessRules maintenanceBusinessRules;

    @Override
    public CreatedMaintenanceResponse add(CreateMaintenanceRequest request) {
        maintenanceBusinessRules.CheckCarAvailabilityForMaintenance(request.getCarId());

        Maintenance maintenance = modelMapperService.forRequest().map(request, Maintenance.class);
        Maintenance createdMaintenance = maintenanceRepository.save(maintenance);

        Optional<Car> car = carRepository.findById(request.getCarId());
        car.get().setState(2);
        carRepository.save(car.get());

        CreatedMaintenanceResponse createdMaintenanceResponse = modelMapperService.forResponse().map(createdMaintenance, CreatedMaintenanceResponse.class);

        return createdMaintenanceResponse;
    }
}
