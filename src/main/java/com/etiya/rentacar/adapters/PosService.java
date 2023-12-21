package com.etiya.rentacar.adapters;

import org.springframework.stereotype.Service;

@Service
public interface PosService {
    boolean pay(PaymentData paymentData);
}
