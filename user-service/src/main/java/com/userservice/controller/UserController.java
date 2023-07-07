package com.userservice.controller;


import com.userservice.dto.UserRequest;
import com.userservice.entities.User;
import com.userservice.exceptions.UserNotFoundException;
import com.userservice.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(path = "/user")
public class UserController {
     Logger logger  = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    //create User Endpoint


    @PostMapping("/addUser")
    public ResponseEntity<User> createUser(@RequestBody UserRequest user)
    {

        User userResponse  = userService.saveUser(user);

        return   ResponseEntity.ok(userResponse);

    }


    // getAll User

    @GetMapping("/getusers")
    @CircuitBreaker(name = "GetAllUserCircuitBraker" ,fallbackMethod="getAllUserGallBack")
    public ResponseEntity<?> getAllUser()
    {


        List<User>  allUsers = userService.getAllUser();

        return ResponseEntity.ok(allUsers);
    }

    //getOneUser

    @GetMapping("/getuser/{id}")
    public ResponseEntity<User>  getUser(@PathVariable  int id) throws UserNotFoundException {
        User user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }



    private  ResponseEntity<?>  getAllUserGallBack(Exception e){
        return new  ResponseEntity("Some sever might be down",HttpStatus.INTERNAL_SERVER_ERROR);
    }




}
