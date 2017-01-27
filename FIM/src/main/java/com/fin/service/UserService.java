package com.fin.service;

import java.util.List;

import com.fin.model.UserDetails;

public interface UserService {
	
	UserDetails findByUserName(String userName);
	UserDetails save(UserDetails userDetails);
	UserDetails findByIdNo(String idNo);
	UserDetails findByMobileNo(String mobileNo);
	List<UserDetails> findAll();
}
