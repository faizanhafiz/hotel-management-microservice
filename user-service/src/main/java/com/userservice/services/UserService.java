package com.userservice.services;


import com.userservice.entities.User;
import com.userservice.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    User saveUser(User user);

   List<User> getAllUser();


    User getUser(int id) throws UserNotFoundException;
}
