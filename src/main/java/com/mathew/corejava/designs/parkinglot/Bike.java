package com.mathew.corejava.designs.parkinglot;

public class Bike extends Vehicle {
	
	public Bike(int id) {
		super(id);
	}
	public ParkingType getParkingType() {
		return ParkingType.SMALL;
	}

	public double getParkingCharge() {
		return 5;
	}

}
