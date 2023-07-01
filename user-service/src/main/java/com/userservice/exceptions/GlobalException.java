package com.userservice.exceptions;


import com.userservice.dto.ResponseApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseApi>  globalUserNOtFoundException(UserNotFoundException ex)
    {

        String message = ex.getMessage();
        ResponseApi responseApi = ResponseApi.builder().
                message(message)
                        .success(false)
                                .status(HttpStatus.NOT_FOUND).build();

        return new  ResponseEntity<>(responseApi, HttpStatus.NOT_FOUND);

    }
}
