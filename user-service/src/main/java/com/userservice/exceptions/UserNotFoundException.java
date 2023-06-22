package com.userservice.exceptions;

public class UserNotFoundException extends Exception{



    public UserNotFoundException()
    {
        super("User not Found");
    }

   public  UserNotFoundException(String message)
    {
        super(message);
    }
}
