package com.retail.RetailOffer.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.RetailOffer.Entity.Transaction;
import com.retail.RetailOffer.Respository.RetailOfferTransactionRepository;
import com.retail.RetailOffer.util.PointsCalc;
import com.retail.RetailOffer.view.PointsView;
import com.retail.RetailOffer.view.ReportView;

@Service
public class RetailOfferService {

	@Autowired
	private RetailOfferTransactionRepository transactionRepository;
	
	
	public Transaction createTransaction(Transaction transaction) {
		long points = PointsCalc.getPoints(Long.valueOf(transaction.getAmount()));
		transaction.setPoints(points);
		transaction.setTransactionDate(new Date());
		return transactionRepository.save(transaction);
	}
	
	public List<Transaction> getAllTransactions(String customerId) {
		 return  transactionRepository.findByCustomerId(customerId);
	}
	
	public Optional<Transaction> getTransaction(String transactionId) {
		 return  transactionRepository.findById(transactionId);
	}
	
	public List<ReportView> getThreeMonthsPoints() {
		
		List<ReportView> reportViews = new ArrayList();
		
		List<Transaction>  listTran = transactionRepository.findByThreeMonthsPoints();
		
		
		
		Map<String, List<Transaction>> transByCustIDMap = listTran.stream()
				.collect(Collectors.groupingBy(Transaction::getCustomerId));
		
		for (Map.Entry<String, List<Transaction>> entry : transByCustIDMap.entrySet()) {
			
			ReportView reportView = new ReportView();
			List<PointsView> pointsViews = new ArrayList<>();
			reportView.setCustomerId(entry.getKey());
			Map<Integer,Long> pointsMap = new HashMap(); 
			
			//Calculation points for each customer and group by month
			for(Transaction trans : entry.getValue()) {
				int month = trans.getTransactionDate().getMonth()+1;
				if(pointsMap.get(month)!=null) {
					pointsMap.put(month, pointsMap.get(month)+trans.getPoints());
				} else {
					pointsMap.put(month, trans.getPoints());
				}
			}
			
			for (Map.Entry<Integer, Long> pointsEntry : pointsMap.entrySet()) {
				PointsView pointsView = new PointsView();
				pointsView.setMonth(pointsEntry.getKey());
				pointsView.setPoints(pointsEntry.getValue());
				pointsViews.add(pointsView);
			}
			reportView.setPointsViews(pointsViews);
			
			
			reportViews.add(reportView);
		}
	
		 return  reportViews;
	}
}