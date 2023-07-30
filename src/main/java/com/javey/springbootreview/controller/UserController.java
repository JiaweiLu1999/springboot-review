package com.javey.springbootreview.controller;

import com.javey.springbootreview.entity.UserEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    @PostMapping()
    public ResponseEntity<String> addUser(@Valid @RequestBody UserEntity user) {
        System.out.println(user);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
}
