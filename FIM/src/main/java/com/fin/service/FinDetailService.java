package com.fin.service;

import java.util.List;

import com.fin.model.FinanceDetails;


public interface FinDetailService {
	
	FinanceDetails findByChitAmount(String chitAmount);
	FinanceDetails save(FinanceDetails finDetails);
	List<FinanceDetails> findAll();
	FinanceDetails findByChitName(String chitName);
}
