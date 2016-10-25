package com.tweetme.service;

import com.google.common.collect.Lists;
import com.tweetme.domain.UserProfile;
import com.tweetme.jpa.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileService {

    @Autowired
    CounterService counterService;
    @Autowired
    GaugeService gaugeService;
    @Autowired
    private UserProfileRepository UserProfileRepository;

    public UserProfileService() {
    }

    public List<UserProfile> getUserProfile() {
        return Lists.newArrayList(UserProfileRepository.findAll());
    }

    public UserProfile createUserProfile (UserProfile UserProfile) {
        return UserProfileRepository.save(UserProfile);
    }

    public UserProfile getUserProfileById(Long iduser) {
        return UserProfileRepository.findOne(iduser);
    }

    public void updateUserProfile(UserProfile UserProfile) {
    	UserProfileRepository.save(UserProfile);
    }

    public void deleteUserProfile(Long iduser) {
    	UserProfileRepository.delete(iduser);
    }
}
