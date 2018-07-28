package com.mathew.corejava.designs.parkinglot;

public abstract class Vehicle {

	int regNumber;
	boolean isParked = false;

	public Vehicle(int id) {
		regNumber = id;
	}

	public boolean isParked() {
		return isParked;
	}

	public void setParked(boolean isParked) {
		this.isParked = isParked;
	}
	
	public int getRegNumber() {
		return regNumber;
	}

	abstract ParkingType getParkingType();

	abstract double getParkingCharge();

}
