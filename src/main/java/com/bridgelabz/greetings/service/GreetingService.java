package com.bridgelabz.greetings.service;

import com.bridgelabz.greetings.entity.Greeting;
import com.bridgelabz.greetings.entity.User;

public interface GreetingService {

    Greeting addGreeting(User user);
    Greeting getGreetingById(long id);
}
