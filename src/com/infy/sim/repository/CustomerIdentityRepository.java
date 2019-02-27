package com.infy.sim.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.infy.sim.entity.CustomerIdentityEntity;

@Repository
public interface CustomerIdentityRepository extends JpaRepository<CustomerIdentityEntity, BigInteger>{

	@Query("select c from CustomerIdentityEntity c where c.firstName=:firstName and c.lastName=:lastName")
	CustomerIdentityEntity findEmailAddress(@Param("firstName") String firstName, @Param("lastName") String lastName);

	@Query("select c from CustomerIdentityEntity c where c.dateOfBirth=:dateOfBirth and c.emailAddress=:emailAddress")
	CustomerIdentityEntity getCustomerIdentity(@Param("dateOfBirth") String dateOfBirth, @Param("emailAddress") String emailAddress);
}
