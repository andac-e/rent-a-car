package com.etiya.rentacar.business.dtos.requests.cars;

import com.etiya.rentacar.entities.concretes.Brand;
import com.etiya.rentacar.entities.concretes.Color;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
    private double dailyPrice;
    private int modelYear;
    private String description;
    private int state;
    private Brand brand;
    private Color color;
}
