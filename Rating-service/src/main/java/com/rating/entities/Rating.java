package com.rating.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;




@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "rating")
public class Rating {



    @Id
    private String id;


    private int userId;



    private int hotelId;

    private int rating;

    private String feedback;




}
