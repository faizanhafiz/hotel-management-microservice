package com.userservice.repositories;

import com.userservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserREpository extends JpaRepository<User,Integer> {
}
