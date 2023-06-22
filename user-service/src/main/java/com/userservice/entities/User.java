package com.userservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {



    @Id
    @Column(name = "userId")
    private int userId ;

    @Column(name = "name" ,length = 25)
    private String name;


    @Column(name = "email")
    private String email;


    @Column(name = "about")
    private String about;






}
