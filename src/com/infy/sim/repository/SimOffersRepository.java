package com.infy.sim.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.infy.sim.entity.SimOffersEntity;

@Repository
public interface SimOffersRepository extends JpaRepository<SimOffersEntity, Integer>{

	@Query("select o from SimOffersEntity o where o.simDetails.simId=:simId")
	SimOffersEntity findSimOfferss(@Param("simId") Integer simId);
	

}
