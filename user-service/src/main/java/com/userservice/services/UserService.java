package com.userservice.services;


import com.userservice.dto.ResponseApi.UserRequest;
import com.userservice.entities.User;
import com.userservice.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {


    User saveUser(UserRequest user);

   List<User> getAllUser();


    User getUser(int id) throws UserNotFoundException;
}
