package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(@Qualifier("repo") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List getAllUsers() {
        return (List) userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> optUser = userRepository.findById(id);
        return optUser.get();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }
}
