package com.rating.service;


import com.rating.dto.RatingRequest;
import com.rating.dto.RatingResponse;
import com.rating.entities.Rating;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface RatingService {

    //create  rating

    public ResponseEntity<Rating > createRating( RatingRequest ratingRequest);

    //get All Rating

    public ResponseEntity<List<RatingResponse>> getAllRating();


    //get Rating by UserID

    public ResponseEntity<List<RatingResponse>>  getRatingBYUserId(int userId );


    //get Rating by Hotel Id

    public ResponseEntity<List<RatingResponse> >  getRatingByHotelId(int hotelId);

}
