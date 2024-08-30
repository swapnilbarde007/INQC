package com.spring.swapnil.testingSpringDemo;

public class ShortTable implements Table {
	double height,length;
	
	public ShortTable() {
		this.height=15.5;
		this.length=25.5;
	}
	
	@Override
	public String showDetails() {
		return "Table dimensions(Short): Height: "+this.height+" Lenght: "+this.length;
	}

}
