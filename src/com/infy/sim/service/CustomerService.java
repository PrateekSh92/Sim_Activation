package com.infy.sim.service;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.sim.entity.CustomerEntity;
import com.infy.sim.exception.InvalidCustomerIdException;
import com.infy.sim.exception.InvalidDateOfBirthException;
import com.infy.sim.exception.InvalidDateOfBirthFormat;
import com.infy.sim.exception.InvalidFirstNameException;
import com.infy.sim.exception.InvalidLastNameException;
import com.infy.sim.exception.InvalidUniqueIdException;
import com.infy.sim.repository.CustomerRepository;
import com.infy.sim.repository.SimDetailsRepository;

@Service
public class CustomerService {

	@Autowired
	private SimDetailsRepository simDetailsRepository;

	@Autowired
	private CustomerRepository customerRepository;

	public boolean updateStatus(String firstName, String lastName, String state, String emailAddress,
			String dateOfBirth, BigInteger uniqueIdNumber)
			throws InvalidUniqueIdException, InvalidCustomerIdException, InvalidDateOfBirthFormat,
			InvalidDateOfBirthException, InvalidFirstNameException, InvalidLastNameException, Exception {

		if (String.valueOf(uniqueIdNumber).length() != 16) {
			throw new InvalidUniqueIdException("Invalid unique Id, Id should be 16 digit");
		}

		CustomerEntity customerentity = customerRepository.findCustomerDetails(uniqueIdNumber);

		if (customerentity == null) {
			throw new InvalidCustomerIdException("Invalid Customer unique Id");
		} else {

			String dOB = customerentity.getDateOfBirth();

			String date = dOB.substring(0, dOB.indexOf(' ')).trim();

			System.out.println(date);

			SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
			sdfrmt.setLenient(false);

			try {
				sdfrmt.parse(dateOfBirth);
			}
			/* Date format is invalid */
			catch (ParseException e) {
				throw new InvalidDateOfBirthFormat("Invalid Date Of Birth Format");
			}

			if (!date.equals(dateOfBirth)) {
				throw new InvalidDateOfBirthException("Invalid Date of birth");
			}

			if (!firstName.equals(customerentity.getFirstName())) {
				throw new InvalidFirstNameException("Input Customer First Name is invalid");
			}

			if (!lastName.equals(customerentity.getLastName())) {
				throw new InvalidLastNameException("Input Customer Last Name is invalid");
			}

			String status = "Active";

			simDetailsRepository.updateSimStatus(status, customerentity.getSimDetails().getSimId());

			return true;
		}
	}

}
