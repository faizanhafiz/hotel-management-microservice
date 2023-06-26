package com.hotel.controller;


import com.hotel.dto.HotelRequest;
import com.hotel.dto.HotelResponse;

import com.hotel.exceptions.HotelNotFoundException;
import com.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {




    @Autowired
    private HotelService hotelService;

    @PostMapping("/create")
    public ResponseEntity<HotelResponse> create(@RequestBody HotelRequest request)
    {

        return  ResponseEntity.ok(hotelService.create(request));


    }


    @GetMapping("/getHotelById/{id}")
    public  ResponseEntity<HotelResponse> gethotelById(@PathVariable int id) throws HotelNotFoundException {
        return ResponseEntity.ok(hotelService.getHotelById(id));

    }


    @GetMapping("/hotels")
    public ResponseEntity<List<HotelResponse>> getAllHotels()
    {
        return ResponseEntity.ok(hotelService.getAllHotel());
    }



}
