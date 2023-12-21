package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.cars.CreateCarRequest;
import com.etiya.rentacar.business.dtos.requests.cars.UpdateCarRequest;
import com.etiya.rentacar.business.dtos.responses.cars.CreatedCarResponse;
import com.etiya.rentacar.business.dtos.responses.cars.DeletedCarResponse;
import com.etiya.rentacar.business.dtos.responses.cars.GetAllCarResponse;
import com.etiya.rentacar.business.dtos.responses.cars.UpdatedCarResponse;

import java.util.List;

public interface CarService {
    CreatedCarResponse add(CreateCarRequest request);
    UpdatedCarResponse update(UpdateCarRequest request);
    DeletedCarResponse delete(int id);
    List<GetAllCarResponse> getAll();
}
