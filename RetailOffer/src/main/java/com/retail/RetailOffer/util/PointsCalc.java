package com.retail.RetailOffer.util;

public class PointsCalc {
	public static long getPoints(long amount) {
		long points = 0l;
		if(amount > 100) {
			//100 above
			points = (amount - 100) *2;
			//50 to 100
			points = points + 50;
		} else if(amount > 50) {
			points = amount - 50;
		}
		return points;
		
	}
}
