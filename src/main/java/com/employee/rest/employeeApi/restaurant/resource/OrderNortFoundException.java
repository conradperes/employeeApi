package com.employee.rest.employeeApi.restaurant.resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderNortFoundException extends RuntimeException {
    public OrderNortFoundException(String message) {
        super(message);
    }
}