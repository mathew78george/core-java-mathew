package com.mathew.corejava.algorithms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Test {
  
  public Test() {
    
  }
  
  public static void main(String[] args) {
    Test t = new Test();
    t.check(null);
    int x = 20;
    String sup = (x < 15) ? "small" : (x < 22)? "tiny" : "huge";
  }
  
  public void check(String str) {
    System.out.println("===str===");
  }
  public void check(Object str) {
    System.out.println("===Object===");
  }
//  public void check(Integer str) {
//    System.out.println("===Integer===");
//  }
  public static void main1(int[] args) {
    
  }
  public static void main1(String[] args) {
    StringBuffer b = new StringBuffer();
    System.out.println(b.capacity());
    float f = \u0038;
    System.out.println(f);
   List<Integer> list = new ArrayList<Integer>();
   list.add(1);
   list.add(2);
   list.add(3);
   list.add(5);
   list.add(4);
   Collections.sort(list);
//   System.out.println(Collections.binarySearch(list, 4));
//   date.get
  }
  
  int check() {
    try {
     System.out.println(" try block");
//     System.exit(0);
     return 1;
      
    }catch(Exception e) {
      System.out.println("exception");
      return 2;
    }finally {
      System.out.println("finally"); 
      return 3;
    }
  }
 
}
