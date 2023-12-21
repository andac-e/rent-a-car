package com.etiya.rentacar.business.dtos.requests.payments;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentRequest {
    private int rentalId;
    private double amount;
    private LocalDateTime date;
    private String cardHolder;
    private String creditCardNumber;
    private int cvv;
    private String expirationDate;
}
