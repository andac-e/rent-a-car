package com.etiya.rentacar.business.dtos.responses.cars;

import com.etiya.rentacar.entities.concretes.Brand;
import com.etiya.rentacar.entities.concretes.Color;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedCarResponse {
    private double dailyPrice;
    private int modelYear;
    private String description;
    private int state;
    private int brandId;
    private int colorId;
}
