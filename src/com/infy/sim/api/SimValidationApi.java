package com.infy.sim.api;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.infy.sim.model.SimOffers;
import com.infy.sim.service.SimValidationService;

@RestController
@RequestMapping("/SimAPI")
public class SimValidationApi {

	@Autowired
	private SimValidationService simValidationService;
	
	@RequestMapping(value = "/{serviceNumber}/{simNumber}", method = RequestMethod.GET, headers = "Accept=application/json")

	public ResponseEntity<SimOffers> getSimOffers(@PathVariable BigInteger serviceNumber, @PathVariable BigInteger simNumber) throws Exception {


		SimOffers simOffers = simValidationService.getSimOffers(serviceNumber, simNumber);
		
	
		return new ResponseEntity<SimOffers>(simOffers, HttpStatus.OK);
		
	}


}
 