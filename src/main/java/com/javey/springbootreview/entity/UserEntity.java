package com.javey.springbootreview.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    String id;

    @Size(min = 2)
    String name;

    @Email
    String email;
}
