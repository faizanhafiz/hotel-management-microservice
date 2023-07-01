package com.rating.service;


import com.rating.dto.RatingRequest;
import com.rating.dto.RatingResponse;
import com.rating.entities.Rating;
import com.rating.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements  RatingService{

    @Autowired
    RatingRepository ratingRepository;
    @Override
    public ResponseEntity<Rating>  createRating(RatingRequest ratingRequest) {


        String  id  = UUID.randomUUID().toString();
        Rating rating = Rating.builder()
                .id(id)
                .userId(ratingRequest.getUserId())
                .hotelId(ratingRequest.getHotelId())
                .feedback(ratingRequest.getFeedback())
                .rating(ratingRequest.getRating())

                .build();

        return ResponseEntity.ok(ratingRepository.save(rating));


    }

    @Override
    public ResponseEntity<List<RatingResponse>> getAllRating() {
        List<Rating> ratings= ratingRepository.findAll();
        List<RatingResponse> response  = new ArrayList<>();
        for(Rating rating :ratings)
        {
            response.add(RatingResponse.builder()

                            .feedback(rating.getFeedback())
                            .hotelId(rating.getHotelId())
                            .ratingId(rating.getRating())
                            .userId(rating.getUserId())
                              .build());
        }

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public  ResponseEntity<List<RatingResponse>> getRatingBYUserId(int userId) {


        List<Rating> ratings = ratingRepository.findByUserId(userId);
        List<RatingResponse> response  = new ArrayList<>();
        for(Rating rating :ratings)
        {
            response.add(RatingResponse.builder()

                    .feedback(rating.getFeedback())
                    .hotelId(rating.getHotelId())
                    .ratingId(rating.getRating())
                    .userId(rating.getUserId())
                    .build());
        }

        return  ResponseEntity.status(HttpStatus.OK).body(response);


    }

    @Override
    public ResponseEntity<List<RatingResponse> > getRatingByHotelId(int hotelId)
    {
        List<Rating> ratings = ratingRepository.findByHotelId(hotelId);
        List<RatingResponse> response  = new ArrayList<>();
        for(Rating rating :ratings)
        {
            response.add(RatingResponse.builder()

                    .feedback(rating.getFeedback())
                    .hotelId(rating.getHotelId())
                    .ratingId(rating.getRating())
                    .userId(rating.getUserId())
                    .build());
        }

        return  ResponseEntity.status(HttpStatus.OK).body(response);


    }
}
