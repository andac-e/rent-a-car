package com.etiya.rentacar.core.utilities.exceptions.types;

import lombok.Data;

@Data
public class BusinessProblemDetails extends ProblemDetails {
    public BusinessProblemDetails() {
        setTitle("Business Rule Violation");
        setDetail("Business Problem");
        setType("http://mydomain.com/exceptions/validation");
        setStatus("500");
    }
}
