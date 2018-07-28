package com.mathew.corejava.designs.parkinglot;

public class ParkingController {
	private ParkingLot parkingLot;

	public void configureParkingLot(int levels) {
		parkingLot = new ParkingLot(levels);
		parkingLot.initializeLevels();
	}

	public boolean park(Vehicle aVehicle) {
		return parkingLot.park(aVehicle);
	}

	public boolean unpark(Vehicle aVehicle) {
		return parkingLot.unpark(aVehicle);
	}
	
	public double getRevenue() {
		return parkingLot.getParkingRevenue();
	}

	public static void main(String[] args) {
		ParkingController parkController = new ParkingController();
		parkController.configureParkingLot(5);
		for (int ii = 0; ii < 20; ii++) {
			Car aCar = new Car(ii + 1);
			System.out.println(parkController.park(aCar));
		}
		System.out.println("Revenue--->"+parkController.getRevenue());
		System.out.println("Revenue--->"+parkController.getRevenue());
		System.out.println("Revenue--->"+parkController.getRevenue());
		System.out.println("Revenue--->"+parkController.getRevenue());
	}
	
}
