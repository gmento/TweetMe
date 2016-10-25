/**
 * 
 */
package com.tweetme.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "campaign")
public class Campaign {
	
	@Id
	@Column(name = "idCampaign")
    @GeneratedValue()
	public long idCampaign;
	
	@Column(name = "id_user")
	public int idUser;
	
	@Column(name = "campaign_name")
	public String campaignName;
	
	@Column(name = "creating_date")
	public Date creatingDate;
	
	@Column(name = "starting_date")
	public Date startingDate;
	
	@Column(name= "ending_date")
	public Date endingDate;
	
	@Column(name= "active")
	public boolean active;
	
	
	public long getIdCampaign() {
		return idCampaign;
	}
	public void setIdCampaign(long idCampaign) {
		this.idCampaign = idCampaign;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	public Date getCreatingDate() {
		return creatingDate;
	}
	public void setCreatingDate(Date creatingDate) {
		this.creatingDate = creatingDate;
	}
	public Date getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}
	public Date getEndingDate() {
		return endingDate;
	}
	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
}
