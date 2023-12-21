package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.maintenances.CreateMaintenanceRequest;
import com.etiya.rentacar.business.dtos.responses.maintenances.CreatedMaintenanceResponse;

public interface MaintenanceService {
    CreatedMaintenanceResponse add(CreateMaintenanceRequest request);
}
