package com.fin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fin.logging.Log;
import com.fin.model.FinanceDetails;
import com.fin.repository.FinDetailsRepository;
@Service
public class FinDetailServiceImpl implements FinDetailService{

	@Autowired
	FinDetailsRepository finDetailRepo;
	
	@Override
	public FinanceDetails findByChitAmount(String chitAmount) {
		Log.info(this.getClass(), "Inside findByChitAmount chitAmount ["+chitAmount+"]");
		return finDetailRepo.findByChitAmount(chitAmount);
	}

	@Override
	public FinanceDetails save(FinanceDetails finDetails) {
		Log.info(this.getClass(), "Inside save finDetails ["+finDetails+"]");
		return finDetailRepo.save(finDetails);
	}

	@Override
	public List<FinanceDetails> findAll() {
		Log.info(this.getClass(), "Inside findAll");
		return finDetailRepo.findAll();
	}

	@Override
	public FinanceDetails findByChitName(String chitName) {
		Log.info(this.getClass(), "Inside findByChitName ["+chitName+"]");
		return finDetailRepo.findByChitName(chitName);
	}

	@Override
	public void delete(Long id) {
		Log.info(this.getClass(), "Inside delete ["+id+"]");
		finDetailRepo.delete(id);
	}

}
