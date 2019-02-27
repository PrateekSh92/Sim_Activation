package com.infy.sim.api;

import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.infy.sim.service.CustomerService;


@RestController
@RequestMapping("/CustomerAPI")
public class CustomerApi {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/{firstName}/{lastName}/{state}/{emailAddress}/{dateOfBirth}/{uniqueIdNumber}", method = RequestMethod.GET, headers = "Accept=application/json")

	public boolean updateSimStatus(@PathVariable String firstName, @PathVariable String lastName, @PathVariable String state, @PathVariable String emailAddress, @PathVariable String dateOfBirth, @PathVariable BigInteger uniqueIdNumber) throws Exception {

		
		boolean statusUpdated =  customerService.updateStatus(firstName, lastName, state, emailAddress, dateOfBirth, uniqueIdNumber);
		
		
		return statusUpdated;
		
	}

}
