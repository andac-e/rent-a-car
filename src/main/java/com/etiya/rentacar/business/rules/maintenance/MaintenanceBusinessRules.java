package com.etiya.rentacar.business.rules.maintenance;

import com.etiya.rentacar.business.messages.MaintenanceBusinessMessages;
import com.etiya.rentacar.core.utilities.exceptions.types.BusinessException;
import com.etiya.rentacar.dataaccess.abstracts.CarRepository;
import com.etiya.rentacar.dataaccess.abstracts.MaintenanceRepository;
import com.etiya.rentacar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class MaintenanceBusinessRules {
    MaintenanceRepository maintenanceRepository;
    CarRepository carRepository;

    public void CheckCarAvailabilityForMaintenance(int carId) {
        Optional<Car> car = carRepository.findById(carId);
        int carState = car.get().getState();

        switch (carState) {
            case 2:
                throw new BusinessException(MaintenanceBusinessMessages.AlreadyMaintenance);
            case 3:
                throw new BusinessException(MaintenanceBusinessMessages.CarRented);
        }
    }
}
