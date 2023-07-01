package com.userservice.feign;

import com.userservice.dto.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("RATING-SERVER")
public interface RatingFeignService {



    @GetMapping("/rating/user/{id}")
    Rating[] getAllRatingByUserId(@PathVariable int id);


}
