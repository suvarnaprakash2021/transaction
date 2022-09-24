package com.retail.RetailOffer.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

import com.retail.RetailOffer.view.PointsView;

@Entity
@NamedNativeQuery(name = "Transaction.findByThreeMonthsPoints", query = "SELECT TRANSACTION_ID,AMOUNT,CUSTOMER_ID,POINTS,TRANSACTION_DATE\n"
		+ "FROM transaction\n"
		+ "WHERE transaction_date >= DATEADD(MONTH, -3,sysdate) ;", resultClass = Transaction.class)
public class Transaction implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long transactionId;
	private String customerId;
	private Date transactionDate;
	private long amount;
	private Long points;
	
	
	public Long getPoints() {
		return points;
	}
	public void setPoints(Long points) {
		this.points = points;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
}
