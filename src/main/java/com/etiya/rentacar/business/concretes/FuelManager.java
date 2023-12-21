package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.FuelService;
import com.etiya.rentacar.business.dtos.requests.fuels.CreateFuelRequest;
import com.etiya.rentacar.business.dtos.responses.fuels.CreatedFuelResponse;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataaccess.abstracts.FuelRepository;
import com.etiya.rentacar.entities.concretes.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FuelManager implements FuelService {
    FuelRepository fuelRepository;
    ModelMapperService modelMapperService;


    @Override
    public CreatedFuelResponse add(CreateFuelRequest request) {
        Fuel fuel = modelMapperService.forRequest().map(request, Fuel.class);

        Fuel createdFuel = fuelRepository.save(fuel);

        CreatedFuelResponse createdFuelResponse = modelMapperService.forResponse().map(createdFuel, CreatedFuelResponse.class);

        return createdFuelResponse;
    }
}
