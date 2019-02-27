package com.infy.sim.entity;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Sim_Details")
public class SimDetailsEntity {

	@Id
	private int simId; 	
	private BigInteger serviceNumber; 	
	private BigInteger simNumber; 	
	private String simStatus;
	
	public int getSimId() {
		return simId;
	}
	public void setSimId(int simId) {
		this.simId = simId;
	}
	public BigInteger getServiceNumber() {
		return serviceNumber;
	}
	public void setServiceNumber(BigInteger serviceNumber) {
		this.serviceNumber = serviceNumber;
	}
	public BigInteger getSimNumber() {
		return simNumber;
	}
	public void setSimNumber(BigInteger simNumber) {
		this.simNumber = simNumber;
	}
	public String getSimStatus() {
		return simStatus;
	}
	public void setSimStatus(String simStatus) {
		this.simStatus = simStatus;
	}
	
}
