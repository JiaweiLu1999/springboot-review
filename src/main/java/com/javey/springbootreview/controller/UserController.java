package com.javey.springbootreview.controller;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.javey.springbootreview.entity.UserEntity;
import com.javey.springbootreview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public MappingJacksonValue getAllUsers() {

        List<UserEntity> allUsers = userService.getAllUsers();
        MappingJacksonValue users = new MappingJacksonValue(allUsers);
        users.setFilters(new SimpleFilterProvider().addFilter("UserEntityFilter",
                SimpleBeanPropertyFilter.filterOutAllExcept("id", "name")));
        return users;
    }

    @PostMapping()
    public ResponseEntity<String> addUser(@Valid @RequestBody UserEntity user) {
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
