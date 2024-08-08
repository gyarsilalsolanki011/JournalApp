package com.gyarsilalsolanki011.JournalApp.controller;

import com.gyarsilalsolanki011.JournalApp.entity.User;
import com.gyarsilalsolanki011.JournalApp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
@Slf4j
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping("/health-check")
    public String healthCheck(){
        String userName = userService.findByUserName("Ram").getUserName();
        log.debug("Hello {}, Health check started", userName);
        log.warn("Hello {}, I am warning You", userName);
        log.error("Sorry, Health check failed {}.", userName);
        log.info("Hello {}, Health check started....", userName);
        return "You are Healthy";
    }

    @PostMapping("/create-user")
    public void createUser(@RequestBody User user) {
        userService.createNewUser(user);
    }
}
