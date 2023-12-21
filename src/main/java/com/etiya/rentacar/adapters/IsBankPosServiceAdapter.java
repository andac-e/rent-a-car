package com.etiya.rentacar.adapters;

import com.etiya.rentacar.outServices.IsBankService;
import org.springframework.stereotype.Service;

@Service
public class IsBankPosServiceAdapter implements PosService {
    @Override
    public boolean pay(PaymentData paymentData) {
        IsBankService isBankService = new IsBankService();
        return isBankService.makePayment(paymentData.getCardHolder(), paymentData.getExpirationDate(), paymentData.getCreditCardNumber(), paymentData.getCvv(), paymentData.getAmount());
    }
}
