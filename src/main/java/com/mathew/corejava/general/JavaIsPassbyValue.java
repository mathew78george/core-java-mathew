package com.mathew.corejava.general;

public class JavaIsPassbyValue {
  
  public static void main(String[] args) {
    Balloon blue = new Balloon("Blue");
    Balloon red = new Balloon("Red");
    System.out.println("red"+red);
    System.out.println("blue"+blue);
    swap(red, blue);
    System.out.println("red color"+red.getColor());
//    System.out.println("blue color"+blue.getColor());
    changeColor(blue);
    System.out.println(blue.getColor());
//    System.out.println("red color="+red.getColor());
//    System.out.println("blue color="+blue.getColor());
//    foo(blue);
//    System.out.println("blue color="+blue.getColor());
  }
  
  static void changeColor(Balloon b) {
    System.out.println("b"+b);
    Balloon s = b;
    s.setColor("Color Changed");
  }
  
  public static void swap(Balloon o1, Balloon o2){
    System.out.println("O1"+o1);
    System.out.println("O2"+o2);
    Balloon temp = o1;
    o1=o2;
    o2=temp;
    o1.setColor("O1 color");
//    o2.setColor("O2 color");
  }
  
  private static void foo(Balloon balloon) { //baloon=100
    balloon.setColor("Red"); //baloon=100
    balloon = new Balloon("Green"); //baloon=200
    balloon.setColor("Blue"); //baloon = 200
  }

}

class Balloon {

  private String color;

  Balloon(String s) {
    color = s;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
}
