package com.mathew.corejava.threads;

public class ThreadSample1 extends Thread {

  public ThreadSample1(String tName) {
    super(tName);
  }

  public void run() {
    for(int ii = 0; ii < 10; ii++) {
      System.out.println("Inside Run of " + this.getName() + " Counter -->" + ii);
      try {
        Thread.sleep(1000);
      } catch(InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    ThreadSample1 t1 = new ThreadSample1("Thread 1");
    ThreadSample1 t2 = new ThreadSample1("Thread 2");
    ThreadSample1 t3 = new ThreadSample1("Thread 3");
    t1.start();
    t2.start();
    t3.start();
    try {
      Thread.currentThread().join();
    } catch(InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
