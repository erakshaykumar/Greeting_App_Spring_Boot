package com.bridgelabz.greetings.controller;

import com.bridgelabz.greetings.entity.Greeting;
import com.bridgelabz.greetings.entity.User;
import com.bridgelabz.greetings.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;


    @GetMapping("/home")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        User user = new User();
        user.setFirstName(name);
        return greetingService.addGreeting(user);
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "fname",defaultValue = "world") String fname,
                             @RequestParam(value = "lname",defaultValue = "")String lname){
        User user = new User();
        user.setFirstName(fname);
        user.setLastName(lname);
        return greetingService.addGreeting(user);
    }

}
