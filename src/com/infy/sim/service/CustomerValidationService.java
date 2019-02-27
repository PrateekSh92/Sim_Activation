package com.infy.sim.service;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.infy.sim.entity.CustomerIdentityEntity;
import com.infy.sim.exception.InvalidCustomerDetailsException;
import com.infy.sim.exception.InvalidCustomerException;
import com.infy.sim.exception.InvalidEmailException;
import com.infy.sim.model.CustomerIdentity;
import com.infy.sim.repository.CustomerIdentityRepository;


@Service
public class CustomerValidationService {

	@Autowired
	private CustomerIdentityRepository customerIdentityRepository;

	public boolean getEmailAddress(String firstName, String lastName, String emailAddress) throws InvalidCustomerDetailsException, InvalidCustomerException, InvalidEmailException, Exception {

		if(firstName == null || lastName == null || String.valueOf(firstName).length() > 15 || String.valueOf(lastName).length() > 15) {
			throw new InvalidCustomerDetailsException ("Invalid details, Firstname/Lastname should be maximum of 15 characters");
		}

		else
		{
			CustomerIdentityEntity customerIdentityEntity = customerIdentityRepository.findEmailAddress(firstName, lastName);
            
			if(customerIdentityEntity == null)
			{
				throw new InvalidCustomerException ("No customer found for the provided details");
			}
			else
			{
			CustomerIdentity customerIdentity = new CustomerIdentity();


			customerIdentity.setEmailAddress(customerIdentityEntity.getEmailAddress());
			customerIdentity.setFirstName(customerIdentityEntity.getFirstName());
			customerIdentity.setLastName(customerIdentityEntity.getLastName());

			
				if(emailAddress.equals(customerIdentity.getEmailAddress()))
				{
					return true;
				}
				else
				{
					throw new InvalidEmailException ("Invalid email details!!");
				}
			}
		}



	}

}

