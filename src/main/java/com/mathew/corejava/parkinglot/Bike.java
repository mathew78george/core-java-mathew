package com.mathew.corejava.parkinglot;

public class Bike implements Vehicle {
  private VehicleType vType;

  public Bike(VehicleType type) {
    vType = type;
  }

  @Override
  public VehicleSize getSize() {
    return VehicleSize.SMALL;
  }

  @Override
  public VehicleType getType() {
    return vType;
  }

}
