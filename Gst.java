package com.santhoshkumar;

public class Gst {
	public double calculateGst(double cabPriceWithoutGst)
	{
		double gst=(cabPriceWithoutGst*OlaApp.gst_cabs)/100.0;
		return gst;
	}

}
