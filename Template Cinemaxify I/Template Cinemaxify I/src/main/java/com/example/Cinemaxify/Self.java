package com.example.Cinemaxify;

// Override the User Interface methods in Self class
public class Self implements User{

    private String name;
    private String memberName = "self";
    private int age;
    private Long contact;
    private String address;
	@Override
	public void setUserDetails(String name, int age, Long contact, String address) {
		this.name=name;
		this.age=age;
		this.contact=contact;
		this.address=address;
		
	}
	@Override
	public void getUserDetails() {
		System.out.println("Hello "+this.name+" you have entered the following details for "+this.memberName);
		System.out.println("age: "+this.age);
		System.out.println("contact: "+contact);
		System.out.println("address: "+address);
		
	}

}
