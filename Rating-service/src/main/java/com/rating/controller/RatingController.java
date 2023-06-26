package com.rating.controller;

import com.rating.dto.RatingRequest;
import com.rating.dto.RatingResponse;
import com.rating.entities.Rating;
import com.rating.repository.RatingRepository;
import com.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController
{


    @Autowired
    RatingService ratingService;

    @PostMapping("/create")
    public ResponseEntity<Rating> createRating(@RequestBody RatingRequest ratingRequest)
    {

             return  ratingService.createRating(ratingRequest);
    }




    @GetMapping("/getAllRatings")

    public ResponseEntity<List<RatingResponse>> getAllRating(){
        return  ratingService.getAllRating();

    }


    //get Rating by UserID

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RatingResponse>>  getRatingBYUserId(@PathVariable  int userId ){


        return ratingService.getRatingBYUserId(userId);
    }


    //get Rating by Hotel Id
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<RatingResponse> >  getRatingByHotelId(@PathVariable  int hotelId){
        return  ratingService.getRatingByHotelId(hotelId);
    }




}
