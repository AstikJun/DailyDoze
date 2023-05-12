package com.example.dailydoze.service.profileService;

import com.example.dailydoze.model.Profile;

import java.util.Optional;

public interface ProfileService {

    Profile saveProfile(Profile profile);
    void deleteProfileById(Long  id);
    public Optional<Profile> getProfileById(Long id);
    void updateUsername(Long profileId , String username);

  //  Profile save(ProfileDTO profileDTO);
}
