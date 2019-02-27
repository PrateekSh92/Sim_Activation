package com.infy.sim.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infy.sim.entity.SimDetailsEntity;

@Repository
public interface SimDetailsRepository extends JpaRepository<SimDetailsEntity, Integer>{

	@Query("select s from SimDetailsEntity s where s.serviceNumber=:serviceNumber and s.simNumber=:simNumber")
	SimDetailsEntity findSimDetails(@Param("serviceNumber") BigInteger serviceNumber, @Param("simNumber") BigInteger simNumber);
	
     @Modifying(clearAutomatically = true)
	 @Transactional
	 @Query(value="update SimDetailsEntity set simStatus=:status where simId=:simId")
	 void updateSimStatus(@Param("status") String status, @Param("simId") int simId);
}
