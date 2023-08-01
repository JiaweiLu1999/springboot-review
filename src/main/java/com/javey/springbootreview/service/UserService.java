package com.javey.springbootreview.service;

import com.javey.springbootreview.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserEntity> getAllUsers();
}
