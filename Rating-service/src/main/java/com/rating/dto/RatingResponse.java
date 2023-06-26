package com.rating.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RatingResponse {



    private int ratingId;

    private int userId;

    private int hotelId;

    private int rating;

    private String feedback;
}
