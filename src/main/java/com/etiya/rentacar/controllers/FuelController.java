package com.etiya.rentacar.controllers;

import com.etiya.rentacar.business.abstracts.FuelService;
import com.etiya.rentacar.business.dtos.requests.fuels.CreateFuelRequest;
import com.etiya.rentacar.business.dtos.responses.fuels.CreatedFuelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fuels")
@AllArgsConstructor
public class FuelController {
    private FuelService fuelService;

    @PostMapping()
    public CreatedFuelResponse add(@RequestBody @Valid CreateFuelRequest request) {
        return fuelService.add(request);
    }
}
