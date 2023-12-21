package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.CarService;
import com.etiya.rentacar.business.dtos.requests.cars.CreateCarRequest;
import com.etiya.rentacar.business.dtos.requests.cars.UpdateCarRequest;
import com.etiya.rentacar.business.dtos.responses.cars.CreatedCarResponse;
import com.etiya.rentacar.business.dtos.responses.cars.DeletedCarResponse;
import com.etiya.rentacar.business.dtos.responses.cars.GetAllCarResponse;
import com.etiya.rentacar.business.dtos.responses.cars.UpdatedCarResponse;
import com.etiya.rentacar.business.rules.cars.CarBusinessRules;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataaccess.abstracts.CarRepository;
import com.etiya.rentacar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CarManager implements CarService {
    CarRepository carRepository;
    CarBusinessRules carBusinessRules;
    ModelMapperService modelMapperService;

    @Override
    public CreatedCarResponse add(CreateCarRequest request) {
        carBusinessRules.EachBrandCanContainMax10Cars(request.getBrandId());

        Car car = modelMapperService.forRequest().map(request, Car.class);

        Car createdCar = carRepository.save(car);

        CreatedCarResponse createdCarResponse = modelMapperService.forResponse().map(createdCar, CreatedCarResponse.class);

        return createdCarResponse;
    }

    @Override
    public UpdatedCarResponse update(UpdateCarRequest request) {
        Car car = modelMapperService.forRequest().map(request, Car.class);

        Car updatedCar = carRepository.save(car);

        UpdatedCarResponse updatedCarResponse =
                modelMapperService.forResponse().map(updatedCar, UpdatedCarResponse.class);

        return updatedCarResponse;
    }

    @Override
    public DeletedCarResponse delete(int id) {
        Car carToDelete = new Car();
        carToDelete.setId(id);
        carRepository.delete(carToDelete);

        DeletedCarResponse response = new DeletedCarResponse();
        response.setId(id);

        return response;
    }

    @Override
    public List<GetAllCarResponse> getAll() {
        List<Car> cars = carRepository.findAll();
        List<GetAllCarResponse> result = cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                        .map(car, GetAllCarResponse.class)).collect(Collectors.toList());

        return result;
    }
}
