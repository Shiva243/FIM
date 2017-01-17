package com.fin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fin.model.FinanceDetails;
@Repository("finDetailsRepo")
public interface FinDetailsRepository extends MongoRepository<FinanceDetails, Long>{
	FinanceDetails findByChitAmount(String amount);

}
