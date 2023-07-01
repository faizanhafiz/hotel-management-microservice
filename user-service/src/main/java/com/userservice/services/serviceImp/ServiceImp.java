package com.userservice.services.serviceImp;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.userservice.dto.Hotel;
import com.userservice.dto.Rating;
import com.userservice.dto.UserRequest;
import com.userservice.entities.User;
import com.userservice.exceptions.UserNotFoundException;
import com.userservice.repositories.UserREpository;
import com.userservice.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
public class ServiceImp implements UserService {

    Logger logger = LoggerFactory.getLogger(ServiceImp.class);
    @Autowired
    private UserREpository  userREpository;
    @Override
    public User saveUser(UserRequest userRequest) {

        User user = User.builder().
                name(userRequest.getName()).
                email(userRequest.getEmail()).
                about(userRequest.getAbout()).build();



        return userREpository.save(user);
    }

    @Override
    public List<User> getAllUser() {

         List<User> user  =  userREpository.findAll();
         RestTemplate  restTemplate  = new RestTemplate();
         user.stream().map(data->

                 {



                     Rating[]  ratings=  restTemplate.getForObject("http://localhost:8083/rating/user/"+data.getUserId() ,  Rating[].class);

                     List<Rating> rating  = Arrays.stream(ratings).toList();


                     System.out.println("User data ==>"+ data.getUserId());
                     System.out.println("Rating data ==>"+ rating);

                     rating.stream().map(data2->{

                         logger.info("hotel id ",data2.getHotelId());


                         Hotel hotel = restTemplate.getForObject("http://localhost:8082/hotel/getHotelByHotelId/1", Hotel.class);
                         logger.info("hotel data type",hotel.getClass());
                         logger.info("hotel data ===>  ",hotel);
                         data2.setHotel(hotel);
                         return data2;
                     }).collect(Collectors.toList());;

                     data.setRatings(rating);




                     return data;



                 }

                 ).collect(Collectors.toList());

return  user;

    }

    @Override
    public User getUser(int id) throws UserNotFoundException {
        return  userREpository.findById(id).orElseThrow(()-> new UserNotFoundException("User Not found having id "+ id));
    }


}




