package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.payments.CreatePaymentRequest;
import com.etiya.rentacar.business.dtos.responses.payments.CreatedPaymentResponse;

public interface PaymentService {
    CreatedPaymentResponse add(CreatePaymentRequest request);
}
