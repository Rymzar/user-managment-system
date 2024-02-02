package com.example.usermanagment.services;

import com.example.usermanagment.models.User;
import com.example.usermanagment.repositrory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public int registerNewUserServiceMethod(String login, String email, String phone, String password) {
        return userRepository.registerNewUser(login, email, phone, password);
    }
    // End Of Register New User Service Method.

    public List<String> checkUserEmail(String email){
        return userRepository.checkUserEmail(email);
    }
    // End Of Check User Email Services Method.

    public String checkUserPasswordByEmail(String email){
        return userRepository.checkUserPasswordByEmail(email);
    }
    // End Of Check User Password Services Method.

    public User getUserDetailsByEmail(String email){
        return userRepository.GetUserDetailsByEmail(email);
    }
    // End Of Get User Details By Email.

}
