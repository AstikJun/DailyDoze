package com.example.dailydoze.controller;

import com.example.dailydoze.dto.UserLoginDTO;
import com.example.dailydoze.repository.UserRepository;
import com.example.dailydoze.service.DefaultUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private DefaultUserService userService;

    @Autowired
    UserRepository userRepository;


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
