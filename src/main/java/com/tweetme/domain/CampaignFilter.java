package com.tweetme.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "campaignfilter")
public class CampaignFilter {
	
	@Id
    @GeneratedValue()
	public int id;
	
	@Column()
	public int idCampaign;
	
	@Column()
	public String follow;
	
	@Column()
	public String track;
	
	@Column()
	public String location;
	
	@Column()
	public String language;

	
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the idCampaign
	 */
	public int getIdCampaign() {
		return idCampaign;
	}
	/**
	 * @param idCampaign the idCampaign to set
	 */
	public void setIdCampaign(int idCampaign) {
		this.idCampaign = idCampaign;
	}
	/**
	 * @return the follow
	 */
	public String getFollow() {
		return follow;
	}
	/**
	 * @param follow the follow to set
	 */
	public void setFollow(String follow) {
		this.follow = follow;
	}
	/**
	 * @return the track
	 */
	public String getTrack() {
		return track;
	}
	/**
	 * @param track the track to set
	 */
	public void setTrack(String track) {
		this.track = track;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
}
