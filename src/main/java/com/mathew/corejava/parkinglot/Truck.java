package com.mathew.corejava.parkinglot;

public class Truck implements Vehicle {
  private VehicleType vType;

  public Truck(VehicleType type) {
    vType = type;
  }

  @Override
  public VehicleSize getSize() {
    return VehicleSize.MEDIUM;
  }

  @Override
  public VehicleType getType() {
    return vType;
  }
}
