package com.mathew.corejava.threads;

public class DeadlockSolution1 {

  public static void main(String[] args) {
    Thread thread1 = new Thread(new T1(), "Thread-1");
    Thread thread2 = new Thread(new T2(), "Thread-2");
    thread1.start();
    thread2.start();
  }
}

class T1 implements Runnable {

  public void run() {

    synchronized(String.class) {
      try {
        System.out.println(Thread.currentThread().getName() + " has acquired lock "
                           + "on String class and waiting to acquire lock on Object class...");
        Thread.sleep(100);
      } catch(InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

    synchronized(Object.class) {
      try {
        System.out.println(Thread.currentThread().getName() + " has acquired " + "lock on Object class");
        Thread.sleep(100);
      } catch(InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }

    System.out.println(Thread.currentThread().getName() + " has ENDED");
  }
}

class T2 implements Runnable {

  public void run() {

    synchronized(Object.class) {
      System.out.println(Thread.currentThread().getName() + " has acquired lock on "
                         + "Object class and waiting to acquire lock on String class...");
    }

    synchronized(String.class) {
      System.out.println(Thread.currentThread().getName() + " has acquired " + "lock on String class");
    }

    System.out.println(Thread.currentThread().getName() + " has ENDED");
  }
}
