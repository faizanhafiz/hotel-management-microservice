package com.userservice.controller;


import com.userservice.entities.User;
import com.userservice.exceptions.UserNotFoundException;
import com.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {


    @Autowired
    private UserService userService;
    //create User Endpoint


    @PostMapping("/addUser")
    public ResponseEntity<User> createUser(@RequestBody  User user)
    {

        User userResponse  = userService.saveUser(user);

        return   ResponseEntity.ok(userResponse);

    }


    // getAll User

    @GetMapping("/getusers")
    public ResponseEntity<List<User>> getAllUser()
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




}
