package com.etiya.rentacar.business.rules.rental;

import com.etiya.rentacar.business.messages.RentalBusinessMessages;
import com.etiya.rentacar.core.utilities.exceptions.types.BusinessException;
import com.etiya.rentacar.dataaccess.abstracts.CarRepository;
import com.etiya.rentacar.dataaccess.abstracts.RentalRepository;
import com.etiya.rentacar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class RentalBusinessRules {
    RentalRepository rentalRepository;
    CarRepository carRepository;
    public void CheckCarAvailabilityForRental(int carId) {
        Optional<Car> car = carRepository.findById(carId);

        if (car.get().getState() != 1) {
            throw new BusinessException(RentalBusinessMessages.OnlyAvailableCanBeRented);
        }
    }

}
