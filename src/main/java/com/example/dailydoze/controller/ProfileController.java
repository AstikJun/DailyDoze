package com.example.dailydoze.controller;

import com.example.dailydoze.model.Profile;
import com.example.dailydoze.repository.UserRepository;
import com.example.dailydoze.service.profileService.ProfileService;
import com.example.dailydoze.service.userService.DefaultUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    private final DefaultUserService userService;

    private final UserRepository userRepository;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("profile", new Profile());
        return "create-profile-form";
    }

    @PostMapping("/save")
    public String saveProfile(@ModelAttribute("profile") Profile profile, RedirectAttributes redirectAttributes) {
        profileService.saveProfile(profile);
        redirectAttributes.addFlashAttribute("message", "Profile created successfully");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        com.example.dailydoze.model.User users = userRepository.findByEmail(username);

        profile.setUser(users);
        profileService.saveProfile(profile);
        return "redirect:/profile/" + profile.getId();
    }

    @GetMapping("/{id}")
    public String showProfile(@PathVariable Long id, Model model) {
        Optional<Profile> optionalProfile = profileService.getProfileById(id);
        if (optionalProfile.isPresent()) {
            Profile profile = optionalProfile.get();
            model.addAttribute("profile", profile);
            return "show-profile";
        } else {
            return "profile-not-found";
        }




}
    }
