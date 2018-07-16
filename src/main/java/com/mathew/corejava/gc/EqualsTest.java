package com.mathew.corejava.gc;

public class EqualsTest {
  
  public static void main(String[] args) {
    String s1 = "Mathew";
    String s2 = "Mathew";
    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));

    Integer int1 = new Integer(10);
    Integer int2 = new Integer(10);
    System.out.println(int1 == int2);
    System.out.println(int1.equals(int2));
  }

}
