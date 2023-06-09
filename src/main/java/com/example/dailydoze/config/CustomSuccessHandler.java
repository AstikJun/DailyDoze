package com.example.dailydoze.config;

import com.example.dailydoze.dto.UserRegisteredDTO;
import com.example.dailydoze.repository.UserRepository;
import com.example.dailydoze.service.userService.DefaultUserService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
    private final UserRepository userRepository;
    private final DefaultUserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String redirectUrl = null;
        if (authentication.getPrincipal() instanceof DefaultOAuth2User) {
            DefaultOAuth2User userDetails = (DefaultOAuth2User) authentication.getPrincipal();
            String password = authentication.getCredentials().toString();
            System.out.println(password);
            String username = userDetails.getAttribute("email") != null ? userDetails.getAttribute("email") : userDetails.getAttribute("login") + "@gmail.com";
            if (userRepository.findByEmail(username) == null) {
                UserRegisteredDTO user = new UserRegisteredDTO();
                user.setEmail_id(username);
                user.setName(userDetails.getAttribute("email") != null ? userDetails.getAttribute("email") : userDetails.getAttribute("login"));
                user.setPassword(password);
                user.setRole("USER");
                userService.save(user);
                System.out.println(user.toString()  );
            }
        }
        redirectUrl = "/dashboard";
        new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
    }
}
