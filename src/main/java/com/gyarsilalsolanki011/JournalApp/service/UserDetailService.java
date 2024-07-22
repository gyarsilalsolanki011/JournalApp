package com.gyarsilalsolanki011.JournalApp.service;

import com.gyarsilalsolanki011.JournalApp.Entity.User;
import com.gyarsilalsolanki011.JournalApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user != null){
            UserDetails userDetails;
            userDetails = org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUserName())
                    .password(passwordEncoder.encode(user.getPassword()))
                    .roles(user.getRoles().toArray(new String[0]))
                    .build();

            return userDetails;
        }
        throw new UsernameNotFoundException("User Not Found with userName: "+username);
    }
}
