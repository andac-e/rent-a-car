package com.etiya.rentacar.controllers;

import com.etiya.rentacar.business.abstracts.ColorService;
import com.etiya.rentacar.business.dtos.requests.colors.CreateColorRequest;
import com.etiya.rentacar.business.dtos.requests.colors.UpdateColorRequest;
import com.etiya.rentacar.business.dtos.responses.colors.CreatedColorResponse;
import com.etiya.rentacar.business.dtos.responses.colors.DeletedColorResponse;
import com.etiya.rentacar.business.dtos.responses.colors.GetAllColorResponse;
import com.etiya.rentacar.business.dtos.responses.colors.UpdatedColorResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colors")
@AllArgsConstructor
public class ColorController {
    private ColorService colorService;

    @PostMapping()
    public CreatedColorResponse add(@RequestBody @Valid CreateColorRequest request) {
        return colorService.add(request);
    }

    @PutMapping
    public UpdatedColorResponse updated(@RequestBody @Valid UpdateColorRequest request) {
        return colorService.update(request);
    }

    @DeleteMapping
    public DeletedColorResponse deleted(@RequestBody int id) {
        return colorService.delete(id);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<GetAllColorResponse>> getAll() {
        return ResponseEntity.ok(this.colorService.getAll());
    }

}
