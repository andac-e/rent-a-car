package com.etiya.rentacar.business.dtos.responses.maintenances;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedMaintenanceResponse {
    private int id;
    private int carId;
    private LocalDateTime maintenanceDate;
    private String description;
    private double cost;
}
