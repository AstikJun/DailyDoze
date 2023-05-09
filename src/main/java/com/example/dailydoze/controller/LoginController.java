package com.example.dailydoze.controller;

import com.example.dailydoze.dto.UserLoginDTO;
import com.example.dailydoze.repository.UserRepository;
import com.example.dailydoze.service.userService.DefaultUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final DefaultUserService userService;
    private final UserRepository userRepository;


    @ModelAttribute("user")
    public UserLoginDTO userLoginDTO(){
        return new UserLoginDTO();
    }

    @GetMapping
    public String login(){
        return "login";
    }

    @PostMapping
    public void loginUser(@ModelAttribute("user")
                          UserLoginDTO userLoginDTO){
        System.out.println("UserDTO"+userLoginDTO);
        userService.loadUserByUsername(userLoginDTO.getUsername());
    }
}
