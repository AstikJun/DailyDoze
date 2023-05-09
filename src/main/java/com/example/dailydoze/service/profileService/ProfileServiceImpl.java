package com.example.dailydoze.service.profileService;

import com.example.dailydoze.model.Profile;
import com.example.dailydoze.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile saveProfile(Profile profile) {
       return profileRepository.save(profile);
    }

    @Override
    public void deleteProfileById(Long id) {
        profileRepository.deleteById(id);
    }

    @Override
    public Profile getProfileById(Long id) {
        return profileRepository.findById(id).orElse(null);
    }

    @Override
    public void updateUsername(Long profileId, String username) {
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new EntityNotFoundException("Profile not found"));
        profile.setName(username);
        profileRepository.save(profile);

    }
}
