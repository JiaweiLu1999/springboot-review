package com.javey.springbootreview.service.impl;

import com.javey.springbootreview.entity.UserEntity;
import com.javey.springbootreview.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final List<UserEntity> users;

    public UserServiceImpl() {
        this.users = Arrays.asList(
                new UserEntity("1", "jiawei", "123@columbia.edu"),
                new UserEntity("2", "javey", "456@gmail.com")
        );
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return users;
    }
}
