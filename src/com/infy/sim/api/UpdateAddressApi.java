package com.infy.sim.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.sim.model.CustomerAddress;
import com.infy.sim.service.UpdateAddressService;

@RestController
@RequestMapping("/UpdateAddressAPI")
public class UpdateAddressApi {
	
	@Autowired
	private UpdateAddressService updateAddressService;
	
	@RequestMapping(value = "/{addressId}/{address}/{city}/{state}/{pincode}", method = RequestMethod.GET, headers = "Accept=application/json")

	public ResponseEntity<CustomerAddress> updateCustomerAddress(@PathVariable int addressId, @PathVariable String address, @PathVariable String city, @PathVariable String state, @PathVariable int pincode) throws Exception {

		CustomerAddress customerAddress = updateAddressService.updateAddress(addressId, address, pincode, city, state);
		
		return new ResponseEntity<CustomerAddress>(customerAddress, HttpStatus.OK);

  }
	
}