package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entites.UserAddress;
@Repository
public interface UserAdressRepository extends JpaRepository<UserAddress,Integer> {
UserAddress findByPincode(String pincode);
	
	@Query("Select useraddress from UserAddress useraddress order by useraddress.state")
	List<UserAddress> findByState(String state);

}
