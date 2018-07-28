package com.mathew.corejava.designs.parkinglot;

public class ParkingSpace {

	int spaceId;
	Vehicle vehichle;
	boolean isParked;

	public ParkingSpace(Vehicle veh) {
		vehichle = veh;
		spaceId = veh.getRegNumber();
	}

	public int getSpaceId() {
		return spaceId;
	}

	public Vehicle getVehichle() {
		return vehichle;
	}

	public void setVehichle(Vehicle vehichle) {
		this.vehichle = vehichle;
	}

	public boolean isParked() {
		return isParked;
	}

	public void setParked(boolean isParked) {
		this.isParked = isParked;
	}

}
