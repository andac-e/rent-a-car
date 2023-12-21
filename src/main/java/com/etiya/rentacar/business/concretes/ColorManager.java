package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.ColorService;
import com.etiya.rentacar.business.dtos.requests.colors.CreateColorRequest;
import com.etiya.rentacar.business.dtos.requests.colors.UpdateColorRequest;
import com.etiya.rentacar.business.dtos.responses.colors.CreatedColorResponse;
import com.etiya.rentacar.business.dtos.responses.colors.DeletedColorResponse;
import com.etiya.rentacar.business.dtos.responses.colors.GetAllColorResponse;
import com.etiya.rentacar.business.dtos.responses.colors.UpdatedColorResponse;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataaccess.abstracts.ColorRepository;
import com.etiya.rentacar.entities.concretes.Color;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ColorManager implements ColorService {
    ColorRepository colorRepository;
    ModelMapperService modelMapperService;
    @Override
    public CreatedColorResponse add(CreateColorRequest request) {
        Color color = modelMapperService.forRequest().map(request, Color.class);

        Color createdColor = colorRepository.save(color);

        CreatedColorResponse createdColorResponse = modelMapperService.forResponse().map(createdColor, CreatedColorResponse.class);

        return createdColorResponse;
    }

    @Override
    public UpdatedColorResponse update(UpdateColorRequest request) {
        Color color = modelMapperService.forRequest().map(request, Color.class);

        Color updatedColor = colorRepository.save(color);

        UpdatedColorResponse updatedColorResponse =
                modelMapperService.forResponse().map(updatedColor, UpdatedColorResponse.class);

        return updatedColorResponse;
    }

    @Override
    public DeletedColorResponse delete(int id) {
        Color colorToDelete = new Color();
        colorToDelete.setId(id);
        colorRepository.delete(colorToDelete);

        DeletedColorResponse response = new DeletedColorResponse();
        response.setId(id);

        return response;
    }

    @Override
    public List<GetAllColorResponse> getAll() {
        List<Color> colors = colorRepository.findAll();
        List<GetAllColorResponse> result = colors.stream().map(color -> this.modelMapperService.forResponse().map(color, GetAllColorResponse.class)).collect(Collectors.toList());
        return result;
    }
}
