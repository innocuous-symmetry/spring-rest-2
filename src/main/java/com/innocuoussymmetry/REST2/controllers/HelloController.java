package com.innocuoussymmetry.REST2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping()
    public String sayHello() {
        return "Hello!";
    }

    @GetMapping("/{path}")
    public String sayHello(@PathVariable(name="path") String path) {
        return "Hello " + path;
    }
}
