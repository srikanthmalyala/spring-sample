package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/hello")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HelloController {

    @GetMapping
    public String get() {
        return "hello";
    }
}
