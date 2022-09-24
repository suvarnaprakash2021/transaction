package com.retail.RetailOffer.Respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.retail.RetailOffer.Entity.Transaction;

@Repository
public interface RetailOfferTransactionRepository extends CrudRepository<Transaction, String>{

	public List<Transaction> findByCustomerId(String customerId);
	

	public List<Transaction> findByThreeMonthsPoints();
}
