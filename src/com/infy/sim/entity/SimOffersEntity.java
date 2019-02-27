package com.infy.sim.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="SIM_OFFERS")
public class SimOffersEntity {

	@Id
	private int offerId; 	
	private int callQty; 	
	private int cost; 	
	private int dataQty;
	private int duration; 	
	private String offerName;
	@OneToOne
	@JoinColumn(name="simId")
	private SimDetailsEntity simDetails;
	
	public int getOfferId() {
		return offerId;
	}
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}
	public int getCallQty() {
		return callQty;
	}
	public void setCallQty(int callQty) {
		this.callQty = callQty;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getDataQty() {
		return dataQty;
	}
	public void setDataQty(int dataQty) {
		this.dataQty = dataQty;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	public SimDetailsEntity getSimDetails() {
		return simDetails;
	}
	public void setSimDetails(SimDetailsEntity simDetails) {
		this.simDetails = simDetails;
	}
	
}
