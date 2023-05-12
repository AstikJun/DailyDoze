package com.example.dailydoze.controller;

import com.example.dailydoze.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {
    private final UserRepository userRepository;

    @GetMapping
    public String displayDashboard(Model model){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Object principal = SecurityContextHolder. getContext(). getAuthentication(). getPrincipal();

        String username = "";
        if(principal instanceof DefaultOAuth2User){
            DefaultOAuth2User user = (DefaultOAuth2User) securityContext.getAuthentication().getPrincipal();
            model.addAttribute("userDetails", user.getAttribute("name")!= null ?user.getAttribute("name"):user.getAttribute("login"));
        }
        else if (principal instanceof UserDetails) {
            username = ((UserDetails)principal). getUsername();
        } else {
            username = principal. toString();
        }
        return "dashboard";
    }

}
