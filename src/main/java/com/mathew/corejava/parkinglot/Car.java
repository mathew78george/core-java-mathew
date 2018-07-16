package com.mathew.corejava.parkinglot;

public class Car implements Vehicle {

  private VehicleType vType;

  public Car(VehicleType type) {
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
