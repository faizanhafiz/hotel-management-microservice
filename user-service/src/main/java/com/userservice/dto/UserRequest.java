package com.userservice.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;


@Data
@Builder
public class UserRequest {


    private String name;



    private String email;



    private String about;
}
