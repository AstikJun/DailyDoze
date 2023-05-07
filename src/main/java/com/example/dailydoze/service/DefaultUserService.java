package com.example.dailydoze.service;

import com.example.dailydoze.dto.UserRegisteredDTO;
import com.example.dailydoze.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface DefaultUserService extends UserDetailsService {
    User save(UserRegisteredDTO userRegisteredDTO);
}
