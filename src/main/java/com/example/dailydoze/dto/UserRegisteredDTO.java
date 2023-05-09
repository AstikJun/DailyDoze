package com.example.dailydoze.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisteredDTO {

    private String name;
    private String email_id;
    private String password;
    private String role;
}
