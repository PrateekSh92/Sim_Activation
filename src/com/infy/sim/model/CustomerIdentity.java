package com.infy.sim.model;

import java.math.BigInteger;

public class CustomerIdentity {

	private BigInteger uniqueIdNumber;
	private String dateOfBirth;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String state;
	
	
	public BigInteger getUniqueIdNumber() {
		return uniqueIdNumber;
	}
	public void setUniqueIdNumber(BigInteger uniqueIdNumber) {
		this.uniqueIdNumber = uniqueIdNumber;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
