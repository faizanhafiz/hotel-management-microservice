package com.userservice.services.serviceImp;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.userservice.dto.Hotel;
import com.userservice.dto.Rating;
import com.userservice.dto.UserRequest;
import com.userservice.entities.User;
import com.userservice.exceptions.UserNotFoundException;
import com.userservice.feign.HotelFeignService;
import com.userservice.feign.RatingFeignService;
import com.userservice.repositories.UserREpository;
import com.userservice.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceImp implements UserService {


    RestTemplateBuilder restTemplateBuilder;
    private final Logger logger = LoggerFactory.getLogger(ServiceImp.class);

    @Autowired
    private HotelFeignService hotelFeignService;

    @Autowired
    private RatingFeignService ratingFeignService;


    private final UserREpository userREpository;
    private   RestTemplate  restTemplate;



    private EurekaClient eurekaClient;
    @Autowired
    public ServiceImp(UserREpository userREpository, EurekaClient eurekaClient ,RestTemplateBuilder restTemplateBuilder) {
        this.userREpository = userREpository;
    this.restTemplate =restTemplateBuilder.build();
        this.eurekaClient =eurekaClient;

    }
//    @PostConstruct
//    public void initializeRestTemplate() {
//        this.restTemplate = restTemplateBuilder.build();
//    }

    @Override
    public User saveUser(UserRequest userRequest) {
        User user = User.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .about(userRequest.getAbout())
                .build();
        return userREpository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = userREpository.findAll();

        return users.stream().map(user -> {

            Rating[] ratings = ratingFeignService.getAllRatingByUserId(user.getUserId());

           List<Rating> ratingList = Arrays.asList(ratings);

            ratingList.forEach(rating -> {
                Hotel hotel =  hotelFeignService.getHotelByUserId(rating.getHotelId());
                rating.setHotel(hotel);
            });

            user.setRatings(ratingList);
            return user;
        }).collect(Collectors.toList());
    }

    private String getRatingUrl() {
        InstanceInfo nextServerFromEureka = eurekaClient.getNextServerFromEureka("RATING-SERVER", false);
        return  nextServerFromEureka.getHomePageUrl();


    }

    private String getHotelUrl() {
        InstanceInfo nextServerFromEureka = eurekaClient.getNextServerFromEureka("HOTEL-SERVER", false);
        return  nextServerFromEureka.getHomePageUrl();


    }


    @Override
    public User getUser(int id) throws UserNotFoundException {
        return userREpository.findById(id).orElseThrow(() ->
                new UserNotFoundException("User not found with id: " + id));
    }










}
