package com.javey.springbootreview.controller;

import com.javey.springbootreview.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Home {
    @GetMapping("hello")
    public String home() {
        return "Hello World!";
    }

    @GetMapping("hello/{name}")
    public String homePathParam(@PathVariable String name) {
        return "Hello, " + name;
    }

    @GetMapping("custom-error")
    public ResponseEntity<String> postTest() {
        throw new ResourceNotFoundException();
    }
}
