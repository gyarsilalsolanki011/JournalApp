package com.gyarsilalsolanki011.JournalApp.service;

import com.gyarsilalsolanki011.JournalApp.Entity.User;
import com.gyarsilalsolanki011.JournalApp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveUser(User userEntry) {
        userEntry.setRoles(List.of("USER"));
        userRepository.save(userEntry);
    }

    public void saveAdmin(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(List.of("USER", "ADMIN"));
            userRepository.save(user);
        } catch (Exception e) {
            log.error("Error in saving new user {}", user.getUserName(), e);
        }

    }

    public void createNewUser(User userEntry) {
        try {
            userEntry.setPassword(passwordEncoder.encode(userEntry.getPassword()));
            userEntry.setRoles(List.of("USER"));
            userRepository.save(userEntry);
        } catch (Exception e) {
            log.error("Error in saving new user {}", userEntry.getUserName(), e);
        }

    }

    public void deleteByUserName(String userName) {
        userRepository.deleteByUserName(userName);
    }

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public List<User> grtAllUsers() {
        return userRepository.findAll();
    }

    //for testing purpose Bean Created
    public boolean saveNewUser(User userEntry) {
        try {
            userEntry.setPassword(passwordEncoder.encode(userEntry.getPassword()));
            userEntry.setRoles(List.of("USER"));
            userRepository.save(userEntry);
            return true;
        } catch (Exception e) {
            log.error("Error in saving new user {}", userEntry.getUserName(), e);
            return false;
        }
    }
}
