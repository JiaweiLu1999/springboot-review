package com.javey.springbootreview.controller;

import com.javey.springbootreview.entity.UserEntity;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping()
    public List<UserEntity> getAllUsers() {
        return new ArrayList<>();
    }

    @PostMapping()
    public ResponseEntity<String> addUser(@Valid @RequestBody UserEntity user) {
        System.out.println(user);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public EntityModel<UserEntity> getUserById(@PathVariable String id) {
        EntityModel<UserEntity> userEntityModel = EntityModel.of(new UserEntity(id, "john", "123@gmail.com"));
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
        userEntityModel.add(link.withRel("all-users"));

        return userEntityModel;
    }
}
