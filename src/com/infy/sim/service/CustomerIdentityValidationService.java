package com.infy.sim.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.sim.entity.CustomerIdentityEntity;
import com.infy.sim.exception.InvalidCustomerDetailsException;
import com.infy.sim.exception.InvalidCustomerException;
import com.infy.sim.exception.InvalidDateOfBirthFormat;
import com.infy.sim.exception.InvalidEmailException;
import com.infy.sim.repository.CustomerIdentityRepository;

@Service
public class CustomerIdentityValidationService {
	
	@Autowired
	private CustomerIdentityRepository customerIdentityRepository;

	public boolean validateCustomerDetails(String emailAddress, String dob) throws InvalidCustomerDetailsException,InvalidDateOfBirthFormat, InvalidCustomerException, Exception {
		
		if(emailAddress == null || dob == null) {
			throw new InvalidCustomerDetailsException ("Invalid details, Email and date of birth cannot be null");
		}
		
		
		SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
		sdfrmt.setLenient(false);

		try {
			sdfrmt.parse(dob);
		}
		/* Date format is invalid */
		catch (ParseException e) {
			throw new InvalidDateOfBirthFormat("Invalid Date Of Birth Format");
		}
		
				
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(emailAddress);
        if(!m.matches()) 
        {
        	throw new InvalidEmailException("Invalid Email Address!!");
        }
	    
		
		String timestamp = " 00:00:00";
		String dateOfBirth = dob + timestamp;
		
		CustomerIdentityEntity customerIdentityEntity = customerIdentityRepository.getCustomerIdentity(dateOfBirth, emailAddress);
       
		if(customerIdentityEntity == null)
		{
			throw new InvalidCustomerException ("No customer found for the provided details");
		}
		else
		{
			
			return true;
		}
	}

}
