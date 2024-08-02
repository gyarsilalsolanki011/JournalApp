package com.gyarsilalsolanki011.JournalApp.Controller;

import com.gyarsilalsolanki011.JournalApp.Entity.User;
import com.gyarsilalsolanki011.JournalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping("/health-check")
    public String healthCheck(){
        return "You are Healthy";
    }

    @PostMapping("/create-user")
    public void createUser(@RequestBody User user) {
        userService.createNewUser(user);
    }
}
