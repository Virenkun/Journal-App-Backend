package com.journal.controller;

import com.journal.entity.Config;
import com.journal.entity.User;
import com.journal.repositry.ConfigRepository;
import com.journal.services.UserService;
import com.journal.services.WeatherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @Autowired
    private WeatherServices weatherServices;

    @Autowired
    private ConfigRepository c;
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/weather")
    public ResponseEntity<?> getWeather() {
        return weatherServices.getWeather("Hyderabad");
    }

    @PostMapping("/config")
    public void setConfig(@RequestBody Config config) {
        c.save(config);
    }

}
