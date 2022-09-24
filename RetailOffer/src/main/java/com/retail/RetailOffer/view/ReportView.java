package com.retail.RetailOffer.view;

import java.util.List;

import com.retail.RetailOffer.Entity.Transaction;



public class ReportView {
	private String customerId;
    private List<PointsView> pointsViews;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public List<PointsView> getPointsViews() {
		return pointsViews;
	}
	public void setPointsViews(List<PointsView> pointsViews) {
		this.pointsViews = pointsViews;
	}


}
