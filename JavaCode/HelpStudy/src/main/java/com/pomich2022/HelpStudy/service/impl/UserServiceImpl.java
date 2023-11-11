package com.pomich2022.HelpStudy.service.impl;

import com.pomich2022.HelpStudy.models.User;
import com.pomich2022.HelpStudy.repository.UserRepository;
import com.pomich2022.HelpStudy.service.inerf.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class UserServiceImpl implements UserServiceInterface {
    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password, boolean acceptedRules, LocalDateTime dateOfRegistration) {
        User checkingUser = userRepository.findByEmail(email);

        if (checkingUser != null) throw new RuntimeException("User with email" + email + "already exist");
        User user = new User(firstName, lastName, email, password, acceptedRules, LocalDateTime.now());
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }
}
