package com.userservice.feign;
import com.userservice.dto.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient("HOTEL-SERVER")
public interface HotelFeignService {


    @GetMapping("/hotel/getHotelByHotelId/{hotelId}")
    Hotel getHotelByUserId(@PathVariable int hotelId);


}
