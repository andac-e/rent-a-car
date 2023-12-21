package com.etiya.rentacar.outServices;

public class IsBankService {
    public boolean makePayment(String creditCardNumber, String cardHolder, String expirationDate, int cvv, double amount) {
        if (amount>5000) {
            return false;
        }
        return true;
    }
}
