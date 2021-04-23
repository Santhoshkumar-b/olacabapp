package com.santhoshkumar;

public class UserDetails {
	long mobileno;
	String password;
	public UserDetails(long mobileno, String password) {
		super();
		this.mobileno = mobileno;
		this.password = password;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	


}
