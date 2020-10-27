package com.example.demo.service;

import com.example.demo.domain.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(Long id);
    User saveUser(User user);
    void deleteUserById(long id);
}
