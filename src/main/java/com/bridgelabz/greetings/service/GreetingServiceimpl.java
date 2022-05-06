package com.bridgelabz.greetings.service;

import com.bridgelabz.greetings.entity.Greeting;
import com.bridgelabz.greetings.entity.User;
import com.bridgelabz.greetings.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingServiceimpl implements GreetingService {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private GreetingRepository greetingRepository;
    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
    }

    @Override
    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id).get();
    }

    @Override
    public List<Greeting> getAll() {
        return greetingRepository.findAll();
    }


}
