package com.example.usermanagment.services;

import com.example.usermanagment.repositrory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public int registerNewUserServiceMethod(String login, String email, String phone, String password) {
        return userRepository.registerNewUser(login, email, phone, password);
    }
}
