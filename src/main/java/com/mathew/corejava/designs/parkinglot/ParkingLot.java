package com.mathew.corejava.designs.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
	int numberOfLevels;
	List<ParkingLevel> parkingLevels;
	Map<Integer, ParkingLevel> parkingLvlLokUp = new HashMap<Integer, ParkingLevel>();

	public ParkingLot(int levels) {
		numberOfLevels = levels;

	}

	public void initializeLevels() {
		parkingLevels = new ArrayList<ParkingLevel>(numberOfLevels);
		for (int ii = 0; ii < numberOfLevels; ii++) {
			int small = 4;
			int medium = 4;
			int large = 2;
			ParkingLevel aLevel = new ParkingLevel(ii, small, medium, large);
			parkingLevels.add(aLevel);
		}
	}

	public boolean park(Vehicle vehicle) {
		if (isFull()) {
			return false;
		}
		for (ParkingLevel aLevel : parkingLevels) {
			if (!aLevel.isFull(vehicle.getParkingType())) {
				aLevel.park(vehicle);
				parkingLvlLokUp.put(new Integer(vehicle.getRegNumber()), aLevel);
				break;
			}
		}
		return true;
	}

	public boolean unpark(Vehicle vehicle) {
		ParkingLevel aLevel = parkingLvlLokUp.get(vehicle.getRegNumber());
		if (aLevel == null) {
			return false;
		}
		return aLevel.unpark(vehicle);
	}

	public double getParkingRevenue() {
		double revenue = 0;
		for (ParkingLevel aLevel : parkingLevels) {
			revenue = revenue + aLevel.getParkingRevenue();
		}
		return revenue;
	}

	private boolean isFull() {
		boolean full = false;
		for (ParkingLevel aLevel : parkingLevels) {
			full = aLevel.isAllFull();
		}
		return full;
	}

}
