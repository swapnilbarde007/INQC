package com.car.dealership.carDealership;

public class SportsCar implements Car {
	String ownerName;
	Tyre tyre;

//	public SportsCar(Tyre tyre) {
//		this.tyre=tyre;
//	}


	public void setTyre(Tyre tyre) {
		this.tyre = tyre;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "Sports Car"+tyre.getTyreInfo();
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
