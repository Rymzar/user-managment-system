package com.example.usermanagment.rest_controllers;

import com.example.usermanagment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class RegisterApiController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity registerNewUser(@RequestParam("login") String login,
                                          @RequestParam("email")String email,
                                          @RequestParam("phone")String phone,
                                          @RequestParam("password")String password) {
        if (login.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
            return new ResponseEntity<>("Please complete all fields", HttpStatus.BAD_REQUEST);
        }

        String hashed_password = BCrypt.hashpw(password, BCrypt.gensalt());

        int result = userService.registerNewUserServiceMethod(login, email, phone, hashed_password);

        if (result != 1) {
            return new ResponseEntity<>("Failed to register User", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("User registered Successfully", HttpStatus.OK);

    }
}
