package com.infy.sim.service;

import java.util.regex.Pattern; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.sim.entity.CustomerAddressEntity;
import com.infy.sim.exception.AddressNotFoundException;
import com.infy.sim.exception.InvalidAddressException;
import com.infy.sim.exception.InvalidPincodeException;
import com.infy.sim.exception.SpecialCharacterException;
import com.infy.sim.model.CustomerAddress;
import com.infy.sim.repository.AddressRepository;

@Service
public class UpdateAddressService {

	@Autowired
	private AddressRepository addressRepository;	
	
	
	public CustomerAddress updateAddress(int addressId, String address, int pincode, String city, String state) throws InvalidAddressException, InvalidPincodeException, SpecialCharacterException, AddressNotFoundException, Exception   {
		
		if(String.valueOf(address).length() > 25) {
			throw new InvalidAddressException ("Invalid Address!!Address should be maximum of 25 characters");
		}
		if(String.valueOf(pincode).length() > 6) {
			throw new InvalidPincodeException ("Invalid Pincode!!Pin should be 6 digit number");
		}	
		if ((!Pattern.matches("[a-zA-Z ]+", city)) || (!Pattern.matches("[a-zA-Z ]+", state))) {
			throw new SpecialCharacterException ("Invalid City or State!!City/State should not contain any special characters except space"); 
			} 
		
		CustomerAddressEntity checkCustomerAddressEntity = addressRepository.findAddress(addressId);
		
		if(checkCustomerAddressEntity == null)
		{
			throw new AddressNotFoundException("Invalid AddressId!! Address Id not present in customer address table");
		}
		
		addressRepository.updateCustomerAddress(addressId, address, city, pincode, state);
	
		CustomerAddressEntity customerAddressEntity = addressRepository.findAddress(addressId);
	
		CustomerAddress customerAddress = new CustomerAddress();
		
		customerAddress.setAddressId(customerAddressEntity.getAddressId());
		customerAddress.setAddress(customerAddressEntity.getAddress());
		customerAddress.setPincode(customerAddressEntity.getPincode());
		customerAddress.setCity(customerAddressEntity.getCity());
		customerAddress.setState(customerAddressEntity.getState());
		
		return customerAddress;
	}

}
