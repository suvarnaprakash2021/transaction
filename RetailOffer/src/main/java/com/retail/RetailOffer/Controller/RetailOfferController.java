package com.retail.RetailOffer.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retail.RetailOffer.Entity.Transaction;
import com.retail.RetailOffer.Service.RetailOfferService;
import com.retail.RetailOffer.view.ReportView;

@RestController
@RequestMapping("/api")
public class RetailOfferController {

	@Autowired
	private RetailOfferService offerService;
	
	
	@PostMapping("/createtransaction")
    public Transaction createTransaction(@RequestBody  Transaction transaction){
         return offerService.createTransaction(transaction);
    }
	
	@GetMapping("/getallTransaction/{customerId}")
    public List<Transaction> getAllTransaction(@PathVariable String customerId){
        return offerService.getAllTransactions(customerId);
    }
	
	@GetMapping("/gettransaction/{transactionId}")
    public Optional<Transaction> getTransaction(@PathVariable String transactionId){
        return offerService.getTransaction(transactionId);
    }
	
	@GetMapping("/getlastthreemonthspoints")
    public List<ReportView> getLastThreeMonthsPoints(){
       return offerService.getThreeMonthsPoints();
    }

	
}
