package com.hotel.services;

import com.hotel.dto.HotelRequest;
import com.hotel.dto.HotelResponse;
import com.hotel.entities.Hotel;
import com.hotel.exceptions.HotelNotFoundException;
import com.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelServiceImpl implements  HotelService{



    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public HotelResponse create(HotelRequest request) {
       Hotel hotel = Hotel.builder()
               .name(request.getName())
               .about(request.getAbout())
               .location(request.getLocation())

               .build();

        Hotel  response  = hotelRepository.save(hotel);
        return HotelResponse.builder()
                .id(hotel.getId())
                .about(hotel.getAbout())
                .location(hotel.getLocation())
                .name(hotel.getName())

                .build();
    }

    @Override
    public List<HotelResponse> getAllHotel() {

       List<Hotel> hotels  = hotelRepository.findAll();
       List<HotelResponse> response  = new ArrayList<>();
       for(Hotel hotel : hotels)
       {
           response.add(HotelResponse.builder().id(hotel.getId()).name(hotel.getName()).about(hotel.getAbout())
                           .location(hotel.getLocation())
                   .build());
       }
       return response;
    }

    @Override
    public HotelResponse getHotelById(int id) throws HotelNotFoundException {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(()->new HotelNotFoundException("Hotel not exist with id"+id));
       return HotelResponse.builder()
               .id(hotel.getId())
               .name(hotel.getName())
               .location(hotel.getLocation())
               .about(hotel.getAbout())
               .build();
    }

    @Override
    public HotelResponse getHotelByHotelId(int id) throws HotelNotFoundException {

        Hotel hotel = hotelRepository.findById(id).orElseThrow(()-> new HotelNotFoundException("Hotel not found"));

         return HotelResponse.builder()
                 .id(hotel.getId())
                 .about(hotel.getAbout())
                 .location(hotel.getLocation())
                 .name(hotel.getName())
                 .build();






    }

    //get



}
