package com.userservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    private int ratingId;

    private int userId;

    private int hotelId;

    private int rating;

    private String feedback;

    private Hotel hotel;
}
