package com.santhoshkumar;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OlaApp {
	static Scanner sc = new Scanner(System.in);
	final static int gst_cabs = 7;
	final static double peakPrice = 5;
	final static double totalTraiff = 0.0;
	final static int microPrice=10;
	final static int sedanPrice=15;
	final static int innovaPrice=20;
	static double finalBillPrice=0.0;
	static String bookingChoice = "";
	static Bill bill = new Bill();

	static Map<Long,UserDetails> map=new HashMap<>();
	static String cabName = " ";
	static double finalPrice = 0.0;
	static int kiloMeter=0,hour=0,age=0;
	static LocalDate date=null;
	static LocalTime time = null;
	public static void main(String []args) {

		System.out.println("       -------------------------------------------------------");
		System.out.println("                            Welcome to uber             ");
		System.out.println("       ------------------------------------------------------");
		System.out.println(" ");
		System.out.println("    1.Login");
		System.out.println("    2.New User");
		System.out.println("    3.Exit");
		
		int loginStart = sc.nextInt();
		if (loginStart == 1) {
			Login login = new Login();
			long userMobileNumber=login.getMobileNo();
			if(map.containsKey(userMobileNumber))
			{
				UserDetails userDetails=map.get(userMobileNumber);
				String userPassword=login.getpassword();
				if(userDetails.getPassword().equals(userPassword))
				{
					System.out.println("Login Successfull");
				}
				else {
					System.out.println("Password wrong");
					main(args);
				}
			}
			else {
				System.out.println("Your mobile is not registered");
				main(args);
			}
			
			

		} else if (loginStart == 2) {
			
			UserAccount userAccount=new UserAccount();
			long newuserMobileNo=userAccount.getUserMobileNo();
			String newuserPassword=userAccount.getUserPassword();
			UserDetails user=new UserDetails(newuserMobileNo,newuserPassword);
			map.put(newuserMobileNo,user);
			System.out.println("Registeration Successfull");
			main(args);
			

		} else if (loginStart == 3) {
			System.out.println("Thank You for using uber");
			System.exit(0);
		} else {
			System.out.println("Please Enter a valid Number");
		}
		
		
		
		
		Gst gst=new Gst();
		SeniorCitizen seniorcitizen=new SeniorCitizen();
		System.out.println("-----------------------LOGIN SUCCESSFULL---------------------------");	
		System.out.println("Enter the your destination kilometer: ");
		Scanner sc=new Scanner(System.in);
		int kiloMeter = sc.nextInt();
		
		LocalDate date ;
		LocalDate currentDate = LocalDate.now();
			do {
				
				System.out.println("Please Enter your journey data :");
				String bookingDate = sc.next();
				date = LocalDate.parse(bookingDate);
			} while (date.isBefore(currentDate));
		
		System.out.println("Please Enter your Pick up time: ");
		String PickupTime = sc.next();
		
		LocalTime time = LocalTime.parse(PickupTime);
		int hour = time.getHour();
		
		System.out.println("Enter your date of birth: ");
		String datebirth = sc.next();
		LocalDate dateofBirth = LocalDate.parse(datebirth);
		
		int age = Period.between(dateofBirth, currentDate).getYears();
		
		System.out.println("Select your cab choice");
		System.out.println("1.Micro");
		System.out.println("2.Sedan");
		System.out.println("3.Innova");
		int choice;
		do {
			choice = sc.nextInt();
			switch (choice) {
				case 1:
				Micro mico = new Micro();
				cabName = "Micro";
				FareCalculateMicro calculatemicro=new FareCalculateMicro(); 
				if(hour>=17 && hour<=19)
				{
					System.out.println("Hello");
					double microPriceNoGst=mico.farepricesMicroPeakHour(kiloMeter);
					double microPriceWithGst=gst.calculateGst(microPriceNoGst);
					double finalPriceWithGst=microPriceNoGst+microPriceWithGst;
					 if(age>=60)
					 {
						 finalBillPrice=seniorcitizen.seniorcitizenDeductionPrice(finalPriceWithGst);
						 calculatemicro.finalfareCalculateMicro(cabName,finalBillPrice,date,time);
						 
						 
					 }else {
						 calculatemicro.finalfareCalculateMicro(cabName,finalPriceWithGst,date,time);
					 }
					
					 
				}
				else {

					 double microPriceNoGst = mico.farepriceMicro(kiloMeter);
					 double microPriceWithGst=gst.calculateGst(microPriceNoGst);
					 double finalPriceWithGst=microPriceNoGst+microPriceWithGst;
					 if(age>=60)
					 {
						 finalBillPrice=seniorcitizen.seniorcitizenDeductionPrice(finalPriceWithGst);
						 calculatemicro.finalfareCalculateMicro(cabName,finalBillPrice,date,time);
						 
					 }else {
						 calculatemicro.finalfareCalculateMicro(cabName,finalPriceWithGst,date,time);
						 
					 }
				}
				break;
				
				
			case 2:
				Sedan sedan = new Sedan();
				cabName="Sedan";
				FareCalculateSedan calculatesedan=new FareCalculateSedan(); 
				if(hour>=17 && hour<=19)
				{
					double sedanPriceNoGst=sedan.farepriceSedanPeakHour(kiloMeter);
					double sedanPriceWithGst=gst.calculateGst(sedanPriceNoGst);
					double finalPriceWithGst=sedanPriceNoGst+sedanPriceWithGst;
					 if(age>=60)
					 {
						 finalBillPrice=seniorcitizen.seniorcitizenDeductionPrice(finalPriceWithGst);
						 calculatesedan.finalfareCalculateSedan(cabName,finalBillPrice,date,time);
						 
						 
					 }else {
						 calculatesedan.finalfareCalculateSedan(cabName,finalPriceWithGst,date,time);	
						 
					 }
					
					 
					 
					 
				}
				else {
					
					 
					 double sedanPriceNoGst = sedan.farePriceSedan(kiloMeter);
					 double sedanPriceWithGst=gst.calculateGst(sedanPriceNoGst);
					 double finalPriceWithGst=sedanPriceNoGst+sedanPriceWithGst;
					 if(age>=60)
					 {
						 finalBillPrice=seniorcitizen.seniorcitizenDeductionPrice(finalPriceWithGst);
						 calculatesedan.finalfareCalculateSedan(cabName,finalBillPrice,date,time);
						 
					 }else {
						 calculatesedan.finalfareCalculateSedan(cabName,finalPriceWithGst,date,time);	 
					 }
				}
				
	
				break;
				
			case 3:
				Innova innova = new Innova();
				FareCalculateInnova calculateinnova=new FareCalculateInnova(); 
				cabName = "Innova";
				if(hour>=17 && hour<=19)
				{
					double innovaPriceNoGst=innova.farepriceInnovaPeakHour(kiloMeter);
					double innovaPriceWithGst=gst.calculateGst(innovaPriceNoGst);
					double finalPriceWithGst=innovaPriceNoGst+innovaPriceWithGst;
					 if(age>=60)
					 {
						 finalBillPrice=seniorcitizen.seniorcitizenDeductionPrice(finalPriceWithGst);
						 calculateinnova.finalfareCalculateInnova(cabName,finalBillPrice,date,time);
						
						 
					 }else {
						 calculateinnova.finalfareCalculateInnova(cabName,finalPriceWithGst,date,time);
					 }
					 
					 
					 
					 
				}
				else {
					
					 
					 double innovaPriceNoGst = innova.farePriceInnova(kiloMeter);
					 double innovaPriceWithGst=gst.calculateGst(innovaPriceNoGst);
					 double finalPriceWithGst=innovaPriceNoGst+innovaPriceWithGst;
					 if(age>=60)
					 {
						 finalBillPrice=seniorcitizen.seniorcitizenDeductionPrice(finalPriceWithGst);
						 calculateinnova.finalfareCalculateInnova(cabName,finalBillPrice,date,time);
						 
					 }else {
						 calculateinnova.finalfareCalculateInnova(cabName,finalPriceWithGst,date,time);
						 
					 }
				}
				
				break;
	
			default:
				System.out.println("Please select a valid cab name");
			}
		}while(choice!=1 || choice!=2 || choice!=3);
			sc.close();

	}
	// TODO Auto-generated method stub
	

}
