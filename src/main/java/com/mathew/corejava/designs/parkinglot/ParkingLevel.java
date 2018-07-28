package com.mathew.corejava.designs.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLevel {

	int levelId;
	int availableSpace;
	int samllavailableSpace;
	int mediumavailableSpace;
	int largeavailableSpace;
	Map<Integer, ParkingSpace> smallSpacesHolder;
	Map<Integer, ParkingSpace> mediumSpacesHolder;
	Map<Integer, ParkingSpace> largeSpacesHolder;
	double revenue;

	public ParkingLevel(int lId, int small, int medium, int large) {
		levelId = lId;
		smallSpacesHolder = new HashMap<Integer, ParkingSpace>(small);
		mediumSpacesHolder = new HashMap<Integer, ParkingSpace>(medium);
		largeSpacesHolder = new HashMap<Integer, ParkingSpace>(large);
		samllavailableSpace = small;
		mediumavailableSpace = medium;
		largeavailableSpace = large;
		availableSpace = samllavailableSpace + mediumavailableSpace + largeavailableSpace;
		revenue = 0L;
	}
	public boolean isAllFull() {
		return (availableSpace == 0);
	}
	public boolean isFull(ParkingType type) {
		boolean isFull = false;
		switch (type) {
		case SMALL:
			isFull = samllavailableSpace == 0 ? true : false;
			break;
		case MEDIUM:
			isFull = mediumavailableSpace == 0 ? true : false;
			break;
		case LARGE:
			isFull = largeavailableSpace == 0 ? true : false;
			break;

		default:
			break;
		}
		return isFull;
	}

	public boolean park(Vehicle vehicle) {
		boolean success = false;
		if (isFull(vehicle.getParkingType())) {
			return false;
		}
		ParkingType type = vehicle.getParkingType();
		switch (type) {
		case SMALL:
			success = parkSmallVehicle(vehicle);
			break;
		case MEDIUM:
			success = parkMediumVehicle(vehicle);
			break;
		case LARGE:
			success = parkLargeVehicle(vehicle);
			break;

		default:
			break;
		}
		revenue = revenue + vehicle.getParkingCharge();
		return success;
	}

	public boolean unpark(Vehicle vehicle) {
		if (smallSpacesHolder.isEmpty() && mediumSpacesHolder.isEmpty() && largeSpacesHolder.isEmpty()) {
			return false;
		}
		boolean success = false;
		ParkingType type = vehicle.getParkingType();
		switch (type) {
		case SMALL:
			success = unparkSmallVehicle(vehicle);
			break;
		case MEDIUM:
			success = unparkMediumVehicle(vehicle);
			break;
		case LARGE:
			success = unparkLargeVehicle(vehicle);
			break;

		default:
			break;
		}
		return success;
	}

	public double getParkingRevenue() {
		return revenue;
	}

	private boolean parkSmallVehicle(Vehicle vehicle) {
		if (samllavailableSpace == 0) {
			return false;
		}
		ParkingSpace aSpace = new ParkingSpace(vehicle);
		vehicle.setParked(true);
		smallSpacesHolder.put(vehicle.getRegNumber(), aSpace);
		samllavailableSpace--;
		availableSpace--;
		return true;
	}

	private boolean parkMediumVehicle(Vehicle vehicle) {
		if (mediumavailableSpace == 0) {
			return false;
		}
		ParkingSpace aSpace = new ParkingSpace(vehicle);
		vehicle.setParked(true);
		mediumSpacesHolder.put(vehicle.getRegNumber(), aSpace);
		mediumavailableSpace--;
		availableSpace--;
		return true;
	}

	private boolean parkLargeVehicle(Vehicle vehicle) {
		if (largeavailableSpace == 0) {
			return false;
		}
		ParkingSpace aSpace = new ParkingSpace(vehicle);
		vehicle.setParked(true);
		largeSpacesHolder.put(vehicle.getRegNumber(), aSpace);
		largeavailableSpace--;
		availableSpace--;
		return true;
	}

	private boolean unparkSmallVehicle(Vehicle vehicle) {
		smallSpacesHolder.remove(vehicle.getRegNumber());
		samllavailableSpace++;
		availableSpace++;
		return true;
	}

	private boolean unparkMediumVehicle(Vehicle vehicle) {
		mediumSpacesHolder.remove(vehicle.getRegNumber());
		mediumavailableSpace++;
		availableSpace++;
		return true;
	}

	private boolean unparkLargeVehicle(Vehicle vehicle) {
		largeSpacesHolder.remove(vehicle.getRegNumber());
		largeavailableSpace++;
		availableSpace++;
		return true;
	}

	public static void main(String[] args) {
		System.out.println(ParkingType.MEDIUM.ordinal());
		System.out.println(ParkingType.SMALL.ordinal());
		System.out.println(ParkingType.LARGE.ordinal());
	}

}
