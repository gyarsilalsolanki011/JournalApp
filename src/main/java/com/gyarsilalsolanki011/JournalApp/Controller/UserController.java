package com.gyarsilalsolanki011.JournalApp.Controller;

import com.gyarsilalsolanki011.JournalApp.Entity.User;
import com.gyarsilalsolanki011.JournalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("{userName}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String userName) {
        User userInDb = userService.findByUserName(userName);
        if (userInDb != null) {
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveEntry(userInDb);
        }
        return  new ResponseEntity<>(userInDb, HttpStatus.OK);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<?> getUserBYUserName(@PathVariable String userName) {
        User user = userService.findByUserName(userName);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
