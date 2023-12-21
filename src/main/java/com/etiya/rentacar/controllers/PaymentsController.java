package com.etiya.rentacar.controllers;

import com.etiya.rentacar.business.abstracts.PaymentService;
import com.etiya.rentacar.business.abstracts.RentalService;
import com.etiya.rentacar.business.dtos.requests.payments.CreatePaymentRequest;
import com.etiya.rentacar.business.dtos.requests.rentals.CreateRentalRequest;
import com.etiya.rentacar.business.dtos.responses.payments.CreatedPaymentResponse;
import com.etiya.rentacar.business.dtos.responses.rentals.CreatedRentalResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
@AllArgsConstructor
public class PaymentsController {
    private PaymentService paymentService;

    @PostMapping()
    public CreatedPaymentResponse add(@RequestBody @Valid CreatePaymentRequest request) {
        return paymentService.add(request);
    }
}
