package com.mathew.corejava.designs.parkinglot;

public class Truck extends Vehicle {
	
	public Truck(int id) {
		super(id);
	}
	public ParkingType getParkingType() {
		return ParkingType.SMALL;
	}

	public double getParkingCharge() {
		return 20;
	}

}
