package com.gyarsilalsolanki011.JournalApp.service;

import com.gyarsilalsolanki011.JournalApp.Entity.User;
import com.gyarsilalsolanki011.JournalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveEntry(User userEntry) {
        userEntry.setRoles(List.of("USER"));
        userEntry.setPassword(passwordEncoder.encode(userEntry.getPassword()));
        userRepository.save(userEntry);
    }

    public List<User> grtAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id) {
        return  userRepository.findById(id);
    }

    public void deleteById(ObjectId id) {
        userRepository.deleteById(id);
    }

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

}
