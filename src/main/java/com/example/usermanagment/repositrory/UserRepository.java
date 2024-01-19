package com.example.usermanagment.repositrory;

import com.example.usermanagment.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, Integer> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO USERS(login, email, phone, password) VALUES(:login, :email, :phone, :password)", nativeQuery = true)
    int registerNewUser(@Param("login") String login,
                        @Param("email") String email,
                        @Param("phone") String phone,
                        @Param("password") String password);

}
