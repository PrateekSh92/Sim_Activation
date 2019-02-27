package com.infy.sim.entity;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class CustomerEntity {
	
	@Id
	private BigInteger uniqueIdNumber;
	private String dateOfBirth;
	private String emailAddress;
	private String firstName;
	private String lastName;
	private String idType;
	@OneToOne
	@JoinColumn(name="addressId")
	private CustomerAddressEntity customerAddress;
	@OneToOne
	@JoinColumn(name="simId")
	private SimDetailsEntity simDetails;
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
	public CustomerAddressEntity getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(CustomerAddressEntity customerAddress) {
		this.customerAddress = customerAddress;
	}
	public SimDetailsEntity getSimDetails() {
		return simDetails;
	}
	public void setSimDetails(SimDetailsEntity simDetails) {
		this.simDetails = simDetails;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
}
