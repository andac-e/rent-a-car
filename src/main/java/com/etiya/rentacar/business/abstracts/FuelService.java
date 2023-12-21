package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.fuels.CreateFuelRequest;
import com.etiya.rentacar.business.dtos.responses.fuels.CreatedFuelResponse;

public interface FuelService {
    CreatedFuelResponse add(CreateFuelRequest request);
}
