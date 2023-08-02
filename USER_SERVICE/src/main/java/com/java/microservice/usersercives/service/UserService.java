package com.java.microservice.usersercives.service;

import com.java.microservice.usersercives.entities.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    List<User> getAllUser();
    User getUser(String userId);
}
