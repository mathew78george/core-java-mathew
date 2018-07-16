package com.mathew.corejava.classloaders.testclasses;

import java.util.ArrayList;
import java.util.List;

public class Bar {

  public Bar(String a, String b) {
    System.out.println("Bar Constructor >>> " + a + " " + b);
  }

  public void printCL() {
    List<String> list = new ArrayList<String>();
    System.out.println(" BAR List ClassLoader: " + List.class.getClassLoader());
    System.out.println("Bar ClassLoader: " + Bar.class.getClassLoader());
  }
}
