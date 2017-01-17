package com.fin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fin.model.UserDetails;

@Repository("userRepo")
public interface UserRepository extends MongoRepository<UserDetails, Long>{

	public UserDetails findByUserName(String userName);
	UserDetails findByIdNo(String idNo);
	UserDetails findByMobileNo(String mobileNo);
}
