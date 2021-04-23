package com.santhoshkumar;

public class Micro {
public double farepriceMicro(int kilometer)
{
	int price=kilometer*OlaApp.microPrice;
	System.out.println("Your fare price with out Gst: "+(price));
	return(price);
}


public double farepricesMicroPeakHour(int kilometer)
{
	
	double peakPrices=(OlaApp.microPrice*OlaApp.peakPrice)/100.0;
	double price=(kilometer*OlaApp.microPrice)+peakPrices;
	System.out.println("Your fare price with out Gst: "+(price));
	return (price);
	
	
	
}
		
//		

}


