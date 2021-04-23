package com.santhoshkumar;

import java.time.LocalDate;
import java.time.LocalTime;

public class FareCalculateSedan extends OlaApp {
	public void finalfareCalculateSedan(String cab_name,double finalBillPrice,LocalDate date,LocalTime time) {
		System.out.println("Do you want to conform your booking type yes/no:");
		OlaApp.bookingChoice = sc.next();
		if (OlaApp.bookingChoice.equals("yes") || OlaApp.bookingChoice.equals("YES")) {

			bill.billingDetails(cab_name, finalBillPrice, date, time);
		} else {
			System.exit(0);
		}
		
	}

}
