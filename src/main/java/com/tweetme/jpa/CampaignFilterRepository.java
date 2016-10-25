package com.tweetme.jpa;

import org.springframework.data.repository.CrudRepository;

import com.tweetme.domain.CampaignFilter;

public interface CampaignFilterRepository extends CrudRepository<CampaignFilter, Integer> {
}
