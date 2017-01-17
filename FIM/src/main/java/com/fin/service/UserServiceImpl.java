package com.fin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fin.logging.Log;
import com.fin.model.UserDetails;
import com.fin.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails findByUserName(String userName) {
		Log.info(this.getClass(), "Inside findByUserName userName is [" + userName + "]");
		return userRepo.findByUserName(userName);
	}

	@Override
	public UserDetails save(UserDetails userDetails) {
		Log.info(this.getClass(), "Inside findByUserName userName is [" + userDetails.getUserName() + "]");
		 return userRepo.save(userDetails);
	}

	@Override
	public UserDetails findByIdNo(String idNo) {
		Log.info(this.getClass(), "Inside findByIdNo idNo is [" + idNo + "]");
		return userRepo.findByIdNo(idNo);
	}

	@Override
	public UserDetails findByMobileNo(String mobileNo) {
		Log.info(this.getClass(), "Inside findByMobileNo mobileNo is [" + mobileNo + "]");
		return userRepo.findByMobileNo(mobileNo);
	}

}
