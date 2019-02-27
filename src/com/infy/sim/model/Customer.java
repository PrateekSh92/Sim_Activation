package com.infy.sim.model;

import java.math.BigInteger;

public class Customer {

	private BigInteger uniqueIdNumber;
	private String dateOfBirth;
	private String emailAddress;
	private String firstName;
	private String lastName;
	private String idType;
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
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
