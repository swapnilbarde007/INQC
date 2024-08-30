package com.car.dealership.carDealership;

public class FamilyCar implements Car {
	
	
	String ownerName;
	Tyre tyre;

	public FamilyCar(Tyre tyre) {
		this.tyre=tyre;
	}
	
	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "Family Car"+tyre.getTyreInfo();
	}

	@Override
	public void setOwnerName(String name) {
		this.ownerName=name;

	}

	@Override
	public String getOwnerName() {
		return this.ownerName;
	}

}
