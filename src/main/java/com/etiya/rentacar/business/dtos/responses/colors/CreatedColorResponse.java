package com.etiya.rentacar.business.dtos.responses.colors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatedColorResponse {
    private int id;
    private String name;
}
