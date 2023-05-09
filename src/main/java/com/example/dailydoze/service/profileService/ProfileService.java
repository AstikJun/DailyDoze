package com.example.dailydoze.service.profileService;

import com.example.dailydoze.model.Profile;

public interface ProfileService {

    Profile saveProfile(Profile profile);
    void deleteProfileById(Long  id);
    Profile getProfileById(Long id);
    void updateUsername(Long profileId , String username);
}
