package com.bridgelabz.greetings.service;

import com.bridgelabz.greetings.entity.Greeting;
import com.bridgelabz.greetings.entity.User;

import java.util.List;

public interface GreetingService {

    Greeting addGreeting(User user);

    Greeting getGreetingById(Long id);

    List<Greeting> getAll();

    Greeting editGreetingById(long id, String name);

}
