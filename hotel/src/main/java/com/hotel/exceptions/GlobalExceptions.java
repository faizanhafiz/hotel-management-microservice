package com.hotel.exceptions;


import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptions {


    @ExceptionHandler(HotelNotFoundException.class)
    public Map<String ,Object> globalHotelNotFoundException(HotelNotFoundException ex)
    {
        Map<String ,Object > exceptionresponse = new HashMap<>();
        exceptionresponse.put("message", ex.getMessage());
        exceptionresponse.put("status" , HttpStatus.NOT_FOUND);
        exceptionresponse.put("success",false);
        return exceptionresponse;

    }
}
