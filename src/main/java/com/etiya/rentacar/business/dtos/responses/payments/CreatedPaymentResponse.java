package com.etiya.rentacar.business.dtos.responses.payments;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatedPaymentResponse {
    private int id;
    private int rentalId;
}
