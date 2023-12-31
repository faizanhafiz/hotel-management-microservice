package com.userservice.dto;


import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data


public class ResponseApi {

    private String message;

    private boolean  success;

    private HttpStatus status;
}
