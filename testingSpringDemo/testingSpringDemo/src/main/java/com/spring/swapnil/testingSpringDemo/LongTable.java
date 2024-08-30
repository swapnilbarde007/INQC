package com.spring.swapnil.testingSpringDemo;

public class LongTable implements Table {
	double height,length;
	
	public LongTable() {
		this.height=15.5;
		this.length=50;
	}
	
	@Override
	public String showDetails() {
		// TODO Auto-generated method stub
		return "Table dimensions(Long): Height: "+this.height+" Lenght: "+this.length;
	}

}
