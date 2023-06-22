package com.userservice.entities;


import com.userservice.entities.Rating.Rating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId ;

    @Column(name = "name" ,length = 25)
    private String name;


    @Column(name = "email")
    private String email;


    @Column(name = "about")
    private String about;



    @Transient
    List<Rating> ratings  = new ArrayList<>();








}
