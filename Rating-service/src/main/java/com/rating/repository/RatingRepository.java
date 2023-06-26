package com.rating.repository;

import com.rating.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RatingRepository extends MongoRepository<Rating ,Integer> {

    public List<Rating> findByUserId(int id);
    public List<Rating> findByHotelId(int id);
}
