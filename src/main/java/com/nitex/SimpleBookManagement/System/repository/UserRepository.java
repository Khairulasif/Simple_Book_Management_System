package com.nitex.SimpleBookManagement.System.repository;

import com.nitex.SimpleBookManagement.System.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> findByUsername(String username);


    @Query(value = "SELECT * FROM book_management.users WHERE user_name = :userName", nativeQuery = true)
    User findByUserName(@Param("userName") String userName);

}
