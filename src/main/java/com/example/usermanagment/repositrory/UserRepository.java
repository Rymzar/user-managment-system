package com.example.usermanagment.repositrory;
import com.example.usermanagment.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT email FROM users WHERE email = :email ", nativeQuery = true)
    List<String> checkUserEmail(@Param("email") String email);

    @Query(value = "SELECT password FROM users WHERE email = :email", nativeQuery = true)
    String checkUserPasswordByEmail(@Param("email") String email);

    @Query(value = " SELECT * FROM users WHERE email = :email", nativeQuery = true)
    User GetUserDetailsByEmail(@Param("email") String email);


    @Transactional
    @Modifying
    @Query(value = "INSERT INTO USERS(login, email, phone, password) VALUES(:login, :email, :phone, :password)", nativeQuery = true)
    int registerNewUser(@Param("login") String login,
                        @Param("email") String email,
                        @Param("phone") String phone,
                        @Param("password") String password);
}
