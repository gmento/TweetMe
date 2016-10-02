package com.tweetme.jpa;

import com.tweetme.domain.UserProfile;
import org.springframework.data.repository.CrudRepository;

public interface UserProfileRepository extends CrudRepository<UserProfile, Long> {
}
