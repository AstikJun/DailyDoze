package com.example.dailydoze.service.profileService;

import com.example.dailydoze.model.Profile;
import com.example.dailydoze.repository.ProfileRepository;
import com.example.dailydoze.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;


    @Override
    public Profile saveProfile(Profile profile){
       return profileRepository.save(profile);
    }

    @Override
    public void deleteProfileById(Long id) {
        profileRepository.deleteById(id);
    }

    @Override
    public Optional<Profile> getProfileById(Long id) {
        return profileRepository.findById(id);
    }

    @Override
    public void updateUsername(Long profileId, String username) {
        Profile profile = profileRepository.
                findById(profileId).orElseThrow(() -> new EntityNotFoundException("Profile not found"));
        profile.setName(username);
        profileRepository.save(profile);

    }

   // @Override
 //   public Profile save(ProfileDTO profileDTO) {
//        SecurityContext securityContext = SecurityContextHolder.getContext();
//        org.springframework.security.core.userdetails.User user =
//                (org.springframework.security.core.userdetails.User) securityContext.getAuthentication().getPrincipal();
//        com.example.dailydoze.model.User users = userRepository.findByEmail(user.getUsername());
//
//        Profile profile= new Profile();
//        profile.setName(profileDTO.getName());
//        profile.setIcon(profileDTO.getIcon());
//        profile.setLanguage(profileDTO.getLanguage());
//        profile.setTheme(profileDTO.getTheme());
//        profile.setUser(users);
    // return profileRepository.save(profileDTO);

    //}
}
