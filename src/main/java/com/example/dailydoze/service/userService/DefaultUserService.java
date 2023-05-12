package com.example.dailydoze.service.userService;

import com.example.dailydoze.dto.UserRegisteredDTO;
import com.example.dailydoze.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface DefaultUserService extends UserDetailsService {
    User save(UserRegisteredDTO userRegisteredDTO);
    public User getUserById(Long id);

    User save(User user);
}
