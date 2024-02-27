package com.journal.controller;

import com.journal.entity.User;
import com.journal.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    public ResponseEntity<?> getAllUsers() {
        List<User> all =  userService.getAllUsers();
        if(all.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
    }
}
