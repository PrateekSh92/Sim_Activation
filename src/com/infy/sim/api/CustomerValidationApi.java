package com.infy.sim.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.sim.service.CustomerValidationService;

@RestController
@RequestMapping("/ValidationAPI")
public class CustomerValidationApi {
	
	@Autowired
	private CustomerValidationService customerValidationService;
	
	@RequestMapping(value = "/{emailAddress}/{firstName}/{lastName}", method = RequestMethod.GET, headers = "Accept=application/json")

	public boolean validateEmailAddress(@PathVariable String emailAddress, @PathVariable String firstName, @PathVariable String lastName) throws Exception {


		
		
		boolean validateEmail = customerValidationService.getEmailAddress(firstName, lastName, emailAddress);
		
		
		return validateEmail;
		
	}

}
