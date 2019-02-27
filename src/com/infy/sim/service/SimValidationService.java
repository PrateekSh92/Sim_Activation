package com.infy.sim.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.sim.entity.SimDetailsEntity;
import com.infy.sim.entity.SimOffersEntity;
import com.infy.sim.exception.ActiveSimException;
import com.infy.sim.exception.InvalidDetailsException;
import com.infy.sim.model.SimOffers;
import com.infy.sim.repository.SimDetailsRepository;
import com.infy.sim.repository.SimOffersRepository;

@Service
public class SimValidationService {

	@Autowired
	private SimDetailsRepository simDetailsRepository;
	
	@Autowired
	private SimOffersRepository simOffersRepository;

	public SimOffers getSimOffers(BigInteger serviceNumber, BigInteger simNumber) throws InvalidDetailsException, ActiveSimException, Exception{
		
		if(serviceNumber == null || simNumber == null || String.valueOf(simNumber).length() != 13 || String.valueOf(serviceNumber).length() != 10) {
			throw new InvalidDetailsException ("Invalid details, please check again SIM number/Service number!");
		}
		else {
			SimDetailsEntity simDetailsEntity = simDetailsRepository.findSimDetails(serviceNumber, simNumber);

			if (simDetailsEntity.getSimStatus().equalsIgnoreCase("active")) {
				throw new ActiveSimException ("SIM already active");
			}
			else {
				SimOffersEntity simOffersEntity = simOffersRepository.findSimOfferss(simDetailsEntity.getSimId());

				SimOffers simOffers = new SimOffers();

				simOffers.setCallQty(simOffersEntity.getCallQty());
				simOffers.setCost(simOffersEntity.getCost());
				simOffers.setDataQty(simOffersEntity.getDataQty());
				simOffers.setDuration(simOffersEntity.getDuration());
				simOffers.setOfferId(simOffersEntity.getOfferId());
				simOffers.setOfferName(simOffersEntity.getOfferName());

				return simOffers;
			}
		}
	}
	
}
