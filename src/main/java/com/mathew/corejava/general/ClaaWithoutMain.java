package com.mathew.corejava.general;

public class ClaaWithoutMain implements Cloneable {

  static {
    System.out.println("This is a statis bloack");
  }

  int rollno;
  String name;

  ClaaWithoutMain(int rollno, String name) {
    this.rollno = rollno;
    this.name = name;
  }

  /*public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }*/

  public static void main(String[] args) {
    try {
      ClaaWithoutMain s1 = new ClaaWithoutMain(101, "amit");

      ClaaWithoutMain s2 = (ClaaWithoutMain) s1.clone();
      System.out.println(s2.name);
      System.out.println(s1==s2);
    } catch(CloneNotSupportedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
