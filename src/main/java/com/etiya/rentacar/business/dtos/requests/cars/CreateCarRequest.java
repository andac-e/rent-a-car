package com.etiya.rentacar.business.dtos.requests.cars;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
    @NotNull
    @Min(1)
    @Max(30000)
    private double dailyPrice;
    @NotNull
    private int modelYear;
    @Size(min = 2, max = 30)
    private String description;
    @NotNull
    @Min(1)
    @Max(3)
    private int state;
    @NotNull
    private int brandId;
    @NotNull
    private int colorId;
}

// WS:1
// Fuel -> id, name | Electric, Diesel, Gasoline
// Transformation ->id, name | Manuel, Automatic
// add validation rules for names

// WS:2
// Cars can be sent to maintenance
// Only available cars can be sent to maintenance --> error detail --> This car is already at maintenance
// --> this car can not be sent to maintenance. Status: rented