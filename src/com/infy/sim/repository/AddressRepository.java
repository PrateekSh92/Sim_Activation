package com.infy.sim.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infy.sim.entity.CustomerAddressEntity;

@Repository
public interface AddressRepository extends JpaRepository<CustomerAddressEntity, Integer>{

	 @Modifying(clearAutomatically = true)
	 @Transactional
	 @Query(value="update CustomerAddressEntity set address=:address, city=:city, pincode=:pincode, state=:state where addressId=:addressId")
	 void updateCustomerAddress(@Param("addressId") int addressId, @Param("address") String address, @Param("city") String city, @Param("pincode") int pincode, @Param("state") String state);

	 @Query("select a from CustomerAddressEntity a where a.addressId=:addressId")
	 CustomerAddressEntity findAddress(@Param("addressId") int addressId);
	 

}


