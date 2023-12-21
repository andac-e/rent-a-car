package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.colors.CreateColorRequest;
import com.etiya.rentacar.business.dtos.requests.colors.UpdateColorRequest;
import com.etiya.rentacar.business.dtos.responses.colors.CreatedColorResponse;
import com.etiya.rentacar.business.dtos.responses.colors.DeletedColorResponse;
import com.etiya.rentacar.business.dtos.responses.colors.GetAllColorResponse;
import com.etiya.rentacar.business.dtos.responses.colors.UpdatedColorResponse;

import java.util.List;

public interface ColorService {
    CreatedColorResponse add(CreateColorRequest request);
    UpdatedColorResponse update(UpdateColorRequest request);
    DeletedColorResponse delete(int id);
    List<GetAllColorResponse> getAll();
}
