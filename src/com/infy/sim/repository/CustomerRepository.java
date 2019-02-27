package com.infy.sim.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.infy.sim.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, BigInteger>{

	@Query("select c from CustomerEntity c where c.uniqueIdNumber=:uniqueIdNumber")
	CustomerEntity findCustomerDetails(@Param("uniqueIdNumber") BigInteger uniqueIdNumber);
	
}
