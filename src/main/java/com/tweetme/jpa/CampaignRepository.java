package com.tweetme.jpa;

import org.springframework.data.repository.CrudRepository;

import com.tweetme.domain.Campaign;

public interface CampaignRepository extends CrudRepository<Campaign, Integer> {
}