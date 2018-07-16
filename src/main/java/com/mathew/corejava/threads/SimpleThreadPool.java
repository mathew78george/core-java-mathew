package com.mathew.corejava.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadPool {

  public static void main(String[] args) {
    // demoCachedThreadPoo();
    demoSingleThreadExecutor();
  }

  private static void demoFixedThreadPool() {
    ExecutorService executer = Executors.newFixedThreadPool(5);
    for(int ii = 0; ii < 25; ii++) {
      executer.execute(new WorkerThread("Worker" + ii));
    }
    executer.shutdown();
  }

  private static void demoCachedThreadPoo() {
    ExecutorService executer = Executors.newCachedThreadPool();
    for(int ii = 0; ii < 25; ii++) {
      executer.execute(new WorkerThread("Worker" + ii));
    }
    executer.shutdown();
    System.out.println("Here");
  }

  private static void demoSingleThreadExecutor() {
    ExecutorService executer = Executors.newSingleThreadExecutor();
    for(int ii = 0; ii < 25; ii++) {
      executer.execute(new WorkerThread("Worker" + ii));
    }
    executer.shutdown();
    System.out.println("Here");
  }
}

class WorkerThread implements Runnable {
  private String name;

  public WorkerThread(String tName) {
    name = tName;
  }

  @Override
  public void run() {
    System.out.println("Run Method of " + name);
    executeJob();

  }

  private void executeJob() {
    System.out.println("executeJob Method of " + name);
    try {
      Thread.sleep(1000);
    } catch(InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
