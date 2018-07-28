package com.mathew.corejava.designs.parkinglot;

public class Car extends Vehicle {
	
	public Car(int id) {
		super(id);
	}

	public ParkingType getParkingType() {
		return ParkingType.MEDIUM;
	}

	public double getParkingCharge() {
		return 10;
	}

}
