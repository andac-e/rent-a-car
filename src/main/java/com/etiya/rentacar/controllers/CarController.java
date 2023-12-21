package com.etiya.rentacar.controllers;

import com.etiya.rentacar.business.abstracts.CarService;
import com.etiya.rentacar.business.dtos.requests.cars.CreateCarRequest;
import com.etiya.rentacar.business.dtos.requests.cars.UpdateCarRequest;
import com.etiya.rentacar.business.dtos.responses.cars.CreatedCarResponse;
import com.etiya.rentacar.business.dtos.responses.cars.DeletedCarResponse;
import com.etiya.rentacar.business.dtos.responses.cars.GetAllCarResponse;
import com.etiya.rentacar.business.dtos.responses.cars.UpdatedCarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarController {
    private CarService carService;

    @PostMapping()
    public CreatedCarResponse add(@RequestBody @Valid CreateCarRequest request) {
        return carService.add(request);
    }

    @PutMapping
    public UpdatedCarResponse updated(@RequestBody @Valid UpdateCarRequest request) {
        return carService.update(request);
    }

    @DeleteMapping
    public DeletedCarResponse deleted(@RequestBody int id) {
        return carService.delete(id);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<GetAllCarResponse>> getAll() {
        return ResponseEntity.ok(this.carService.getAll());
    }
}
