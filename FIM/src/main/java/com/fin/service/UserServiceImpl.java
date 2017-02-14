package com.fin.service;

import java.util.List;

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
		return userRepo.findByUserName(userName);
	}

	@Override
	public UserDetails save(UserDetails userDetails) {
		Log.info(this.getClass(), "Inside findByUserName userName is [" + userDetails.getUserName() + "]");
		 return userRepo.save(userDetails);
	}

	@Override
	public UserDetails findByIdNo(String idNo) {
		return userRepo.findByIdNo(idNo);
	}

	@Override
	public UserDetails findByMobileNo(String mobileNo) {
		return userRepo.findByMobileNo(mobileNo);
	}

	@Override
	public List<UserDetails> findAll() {
		//Log.info(this.getClass(), "Inside findAll");
		return userRepo.findAll();
	}
	@Override
	public void deleteUserById(Long id) {
		Log.info(this.getClass(), "Inside deleteUserById ["+id+"]");
		 userRepo.delete(id);
	}
}
