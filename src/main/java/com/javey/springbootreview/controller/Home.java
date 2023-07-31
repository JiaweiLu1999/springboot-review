package com.javey.springbootreview.controller;

import com.javey.springbootreview.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Home {
    private MessageSource messageSource;

    @Autowired
    public Home(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping(value = "home")
    public String home() {
        return messageSource.getMessage("home.message", null, "Home",
                LocaleContextHolder.getLocale());
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
