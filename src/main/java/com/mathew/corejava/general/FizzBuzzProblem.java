package com.mathew.corejava.general;

import java.util.HashMap;
import java.util.Map;

public class FizzBuzzProblem {

  private static void printfizzBuzz(int count) {
    for(int ii = 1; ii <= count; ii++) {
      int mod3 = ii % 3;
      int mod5 = ii % 5;
      if(mod3 == 0 && mod5 == 0) {
        System.out.println("fizzbuzz");
      } else if(mod3 == 0) {
        System.out.println("fizz");
      } else if(mod5 == 0) {
        System.out.println("buzz");
      } else {
        System.out.println(ii);
      }
    }
  }

  public static void main(String[] args) {
    assigneeNameTest();
    try {
      Thread.currentThread().sleep(100000000);
    } catch(InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void assigneeNameTest() {
    double tom = (double)Runtime.getRuntime().totalMemory()/(double)(1024 * 1024);
    double m1 = (double)Runtime.getRuntime().freeMemory()/(double)(1024 * 1024);
    Map<String, Integer> nameMap = new HashMap<String, Integer>();
    String startName = "ABCDABCDABCDABCDABCD";
    for(int ii = 0; ii < 3000000; ii++) {
      nameMap.put(startName + ii, ii);
    }
    double m2 = (double)Runtime.getRuntime().freeMemory()/(double)(1024 * 1024);
    System.out.println(tom);
    System.out.println(m1);
    System.out.println(m2);
    System.out.println(m1-m2);
  }

}
