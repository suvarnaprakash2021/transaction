package com.retail.RetailOffer.Respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.retail.RetailOffer.Entity.Customer;

@Repository
public interface RetailOfferCustomerRepository extends CrudRepository<Customer, String>{

}
