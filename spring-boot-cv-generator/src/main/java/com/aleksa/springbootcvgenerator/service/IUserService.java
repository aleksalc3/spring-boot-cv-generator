package com.aleksa.springbootcvgenerator.service;

import com.aleksa.springbootcvgenerator.model.User;

import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void makeAdmin(String username);
}
