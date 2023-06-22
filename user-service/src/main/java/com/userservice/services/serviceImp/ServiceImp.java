package com.userservice.services.serviceImp;

import com.userservice.entities.User;
import com.userservice.exceptions.UserNotFoundException;
import com.userservice.repositories.UserREpository;
import com.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceImp implements UserService {


    @Autowired
    private UserREpository  userREpository;
    @Override
    public User saveUser(User user) {
       return userREpository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return  userREpository.findAll();
    }

    @Override
    public User getUser(int id) throws UserNotFoundException {
        return  userREpository.findById(id).orElseThrow(()-> new UserNotFoundException("User Not found having id "+ id));
    }


}
