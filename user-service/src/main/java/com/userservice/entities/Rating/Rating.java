package com.userservice.entities.Rating;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rating {

    private int  ratingId;

    private  int userId;

    private  int rating;

    private String feedback;
}
