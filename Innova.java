package com.santhoshkumar;

public class Innova {
	public double farePriceInnova(int kilometer)
	{
		int price=kilometer*OlaApp.innovaPrice;
		System.out.println("Your fare price with out Gst: "+(price));
		return(price);
	}


	public double farepriceInnovaPeakHour(int kilometer)
	{
		
		double peakPrices=(OlaApp.innovaPrice*OlaApp.peakPrice)/100.0;
		double price=(kilometer*OlaApp.innovaPrice)+peakPrices;
		System.out.println("Your fare price with out Gst: "+(price));
		return (price);
	}

}
