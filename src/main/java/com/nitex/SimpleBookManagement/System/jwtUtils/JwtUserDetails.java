package com.nitex.SimpleBookManagement.System.jwtUtils;

import com.nitex.SimpleBookManagement.System.model.LoginRequest;
import com.nitex.SimpleBookManagement.System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class JwtUserDetails implements UserDetailsService {




    @Autowired
    private UserRepository userRepository;

    private String username;
    private String password;


//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        if ("randomuser123".equals(username)) {
//            return new User("randomuser123",
//                    "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//                    new ArrayList<>());
//        } else {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.nitex.SimpleBookManagement.System.model.User user = userRepository.findByUserName(username);
        if (user != null) {

            return new User(
                    user.getUserName(),
                    user.getPassword(),
                    new ArrayList<>()
            );
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }




}
