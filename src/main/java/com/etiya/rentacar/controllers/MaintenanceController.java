package com.etiya.rentacar.controllers;

import com.etiya.rentacar.business.abstracts.MaintenanceService;
import com.etiya.rentacar.business.dtos.requests.maintenances.CreateMaintenanceRequest;
import com.etiya.rentacar.business.dtos.responses.maintenances.CreatedMaintenanceResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/maintenances")
@AllArgsConstructor
public class MaintenanceController {
    private MaintenanceService maintenanceService;

    @PostMapping()
    public CreatedMaintenanceResponse add(@RequestBody @Valid CreateMaintenanceRequest request) {
        return maintenanceService.add(request);
    }
}
