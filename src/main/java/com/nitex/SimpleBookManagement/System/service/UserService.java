package com.nitex.SimpleBookManagement.System.service;

import com.nitex.SimpleBookManagement.System.model.User;
import com.nitex.SimpleBookManagement.System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {


    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) {

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }


    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof org.springframework.security.core.userdetails.User) {

            org.springframework.security.core.userdetails.User userDetails
                    = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
            String username = userDetails.getUsername();
            System.out.println(username.isEmpty());

            User user = userRepository.findByUserName(username);

            if (user != null) {
                user.setPassword(null);
                return user;
            }
        }


        throw new UsernameNotFoundException("User not found.");
    }


    public void updateUser(User updatedUser) {
        String hashedPassword = passwordEncoder.encode(updatedUser.getPassword());
        updatedUser.setPassword(hashedPassword);
        userRepository.save(updatedUser);
    }

}




