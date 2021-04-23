package com.santhoshkumar;

public class Sedan {
	public double farePriceSedan(int kilometer)
	{
		int price=kilometer*OlaApp.sedanPrice;
		System.out.println("Your fare price with out Gst: "+(price));
		return(price);
	}


	public double farepriceSedanPeakHour(int kilometer)
	{
		
		double peakPrices=(OlaApp.sedanPrice*OlaApp.peakPrice)/100.0;
		double price=(kilometer*OlaApp.sedanPrice)+peakPrices;
		System.out.println("Your fare price with out Gst: "+(price));
		return (price);
	}
		
	

}
