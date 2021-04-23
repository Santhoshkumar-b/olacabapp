package com.santhoshkumar;

public class SeniorCitizen {
	
	public double seniorcitizenDeductionPrice(double finalfareprice)
	{
			double seniorCitizen=(finalfareprice*50)/100.0;
			return(finalfareprice-seniorCitizen);

			
	}

}
