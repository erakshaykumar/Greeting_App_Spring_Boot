package com.bridgelabz.greetings.controller;

import com.bridgelabz.greetings.model.Greeting;
import com.bridgelabz.greetings.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     *URL:localhost:8080/greeting
     @return: {id =1 , content="hello world!}
     * localhost:8080/greeting?name=Akshay
     * @return: { id=2, content="hello Akshay!
     */
    @GetMapping(value={"/greeting","/greeting/","/greeting/home"})
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    /**
    *localhost:8080/greeting/Akshay
    @return: {id =1 , content="hello Akshay!}
     */
    @GetMapping("greeting/{name}")
    public Greeting greetings(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @Autowired
    private IGreetingService greetingService;

    /**
     *localhost:8080/greeting/service
      @return={id =1 , content="hello world!}
     */
    @GetMapping("greeting/service")
    public Greeting greeting() {
        return greetingService.greetingMessage();

    }

}
