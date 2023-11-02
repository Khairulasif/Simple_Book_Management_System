package com.nitex.SimpleBookManagement.System.controller;

import com.nitex.SimpleBookManagement.System.jwtUtils.TokenManager;
import com.nitex.SimpleBookManagement.System.model.LoginRequest;
import com.nitex.SimpleBookManagement.System.model.LoginResponse;
import com.nitex.SimpleBookManagement.System.model.User;
import com.nitex.SimpleBookManagement.System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully.");
    }


    @GetMapping("/profile")
    public User getProfileByUsername() {
        User currentUser = userService.getCurrentUser();
        System.out.println(currentUser);
        return currentUser;


    }


    @PutMapping("/profile/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") Long id, @RequestBody User updatedUser) {


        userService.updateUser(updatedUser);

        return ResponseEntity.ok("User updated successfully.");
    }

}
