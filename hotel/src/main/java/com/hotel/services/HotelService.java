package com.hotel.services;


import com.hotel.dto.HotelRequest;
import com.hotel.dto.HotelResponse;
import com.hotel.exceptions.HotelNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface HotelService {


    public HotelResponse create(@RequestBody HotelRequest request);


    public List<HotelResponse> getAllHotel();


    public HotelResponse  getHotelById(@PathVariable int id) throws HotelNotFoundException;



    public HotelResponse getHotelByHotelId(@PathVariable int id) throws HotelNotFoundException;


}
