package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {
    @GetMapping("/hello")
    public String sayHello(@RequestParam String name){
        return "Hello " + name + "to the first api";
    }
}
