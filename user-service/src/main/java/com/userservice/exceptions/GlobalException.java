package com.userservice.exceptions;


import com.userservice.dto.ResponseApi.ResponseApi;
import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.swing.text.html.parser.Entity;

@ResponseStatus
public class GlobalException {

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
