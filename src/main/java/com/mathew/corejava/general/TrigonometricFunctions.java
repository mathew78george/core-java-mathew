package com.mathew.corejava.general;

public class TrigonometricFunctions {

  public static void main(String[] args) {

    double angle = 90;
    // converting angle to radians.
    double angleInRadians = Math.toRadians(angle);
    System.out.println(angleInRadians);
    double sineOfNum = Math.sin(angleInRadians);
    double cosineOfNum = Math.cos(angleInRadians);
    double tangentOfNum = Math.tan(angleInRadians);

    double secOfNum = (1 / sineOfNum);
    double cosecOfNum = (1 / cosineOfNum);
    double cotOfNum = (1 / tangentOfNum);

    System.out.println("sin(" + angle + ") = " + sineOfNum);
    System.out.println("cos(" + angle + ") = " + cosineOfNum);
    System.out.println("tan(" + angle + ") = " + tangentOfNum);

    System.out.println("--------------------------------");

    System.out.println("sec(" + angle + ") = " + secOfNum);
    System.out.println("cosec(" + angle + ") = " + cosecOfNum);
    System.out.println("cot(" + angle + ") = " + cotOfNum);

  }
}
