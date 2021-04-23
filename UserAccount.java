package com.santhoshkumar;


public class UserAccount extends OlaApp {
	
	public long getUserMobileNo()
	{
		System.out.println("Enter your mobile number");
		long mobileNo=sc.nextLong();
		isvalidateMobileNo(mobileNo);
		return mobileNo;
	}
	public boolean isvalidateMobileNo(long  mobileNo)
	{
		String MobileNO=String.valueOf(mobileNo);
		if(MobileNO.length()!=10)
		{
			System.out.println("Enter a valid mobile number");
			getUserMobileNo();
			return false;
		}
		return true;
	}
		
	
	public String getUserPassword()
	{
		System.out.println("Enter your password");
		String password=sc.next();
		isvalidatepassword(password);
		
		return password;
	}
	public boolean isvalidatepassword(String password)
	{
		if(password.length()<8) {
			System.out.println("Enter password with Atleast 8 character");
			getUserPassword();
			return false;
		}
		return true;
	
	}
	
	
	
	
	

}
