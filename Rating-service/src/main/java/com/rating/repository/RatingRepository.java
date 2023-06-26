package com.rating.repository;

import com.rating.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RatingRepository extends MongoRepository<Rating ,Integer> {
}
