package com.example.dailydoze.config;

import com.example.dailydoze.repository.UserRepository;
import com.example.dailydoze.service.DefaultUserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    UserRepository userRepository;

    @Autowired
    DefaultUserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String redirectURL = null;
        if(authentication.getPrincipal() instanceof DefaultOAuth2User){
            DefaultOAuth2User userDetails = (DefaultOAuth2User) authentication.getPrincipal();
            String username = userDetails.getAttribute("email")
                    != null?userDetails.getAttribute("email"):userDetails.getAttribute("login")+"@gmail.com";
//            if(userRepository) //не дописал
        }
    }
}
