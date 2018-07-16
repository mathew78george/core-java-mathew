package com.mathew.corejava.classloaders.testclasses;

import java.util.ArrayList;
import java.util.List;

public class Foo {
  Bar bar;
  public Foo(){
    System.out.println("Fooo");
    bar = new Bar("Mathew", "George");
  }
  static public void main(String args[]) throws Exception {
    System.out.println("Foo Constructor >>> " + args[0] + " " + args[1]);
    Bar bar = new Bar(args[0], args[1]);
    bar.printCL();
  }

  public static void printCL() {
    List<String> list = new ArrayList<String>();
    System.out.println(" FOO List ClassLoader: " + List.class.getClassLoader());
    System.out.println("Foo ClassLoader: " + Foo.class.getClassLoader());
  }
}
