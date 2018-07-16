package com.mathew.corejava.gc;

public class GCMonitorSample {

  public static void main(String[] args) {
    int count = 0;
    while(true){
      System.out.print(".");
      if(count >1000){
        System.out.println("\n");
        count = 0;
      }
      try {
        Thread.sleep(2000);
      } catch(InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
