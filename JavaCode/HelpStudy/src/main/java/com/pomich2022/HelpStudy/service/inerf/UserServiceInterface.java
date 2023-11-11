package com.pomich2022.HelpStudy.service.inerf;

import com.pomich2022.HelpStudy.models.User;

import java.time.LocalDateTime;
import java.util.List;

public interface UserServiceInterface {
    User registerUser(String firstName, String lastName, String email, String password, boolean acceptedRules, LocalDateTime dateOfRegistration);
    List<User> fetchAllUsers();
}
