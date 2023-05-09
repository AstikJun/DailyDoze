package com.example.dailydoze.controller;

import com.example.dailydoze.dto.UserRegisteredDTO;
import com.example.dailydoze.service.userService.DefaultUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("registration")

public class RegistrationController {

    private final DefaultUserService userService;

    public RegistrationController(DefaultUserService userService) {
        super();
        this.userService = userService;
    }
    @ModelAttribute("user")
    public UserRegisteredDTO userRegisteredDTO(){
        return new UserRegisteredDTO();
    }

    @GetMapping
    public String showRegistrationForm(){
        return "register";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user")
                                      UserRegisteredDTO registrationDto){
        userService.save(registrationDto);
        return "redirect:/login";
    }
}
