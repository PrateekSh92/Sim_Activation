package com.infy.sim.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.sim.service.CustomerIdentityValidationService;

@RestController
@RequestMapping("/CustomerValidationAPI")
public class CustomerIdentityValidationApi {

	@Autowired
	private CustomerIdentityValidationService customerIdentityValidationService;
	
	@RequestMapping(value = "/{emailAddress}/{dob}", method = RequestMethod.GET, headers = "Accept=application/json")

	public boolean updateSimStatus(@PathVariable String emailAddress, @PathVariable String dob) throws Exception {

		
		boolean status =  customerIdentityValidationService.validateCustomerDetails(emailAddress, dob);
		
		
		return status;
		
	}
}
