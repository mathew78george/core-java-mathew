package com.mathew.corejava.threads;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {
  int capacity;
  Queue<T> queue = new LinkedList<T>();

  public BlockingQueue(int aSize) {
    capacity = aSize;
  }

  public synchronized void push(T element) throws InterruptedException {
    if(queue.size() == capacity) {
      System.out.println("Wait of Push");
      wait();
    }
    queue.add(element);
    notify();
  }

  public synchronized T pop() throws InterruptedException {
    if(queue.isEmpty()) {
      System.out.println("Wait of Pop");
      wait();
    }
    notify();
    return queue.remove();
  }

  public static void main(String[] args) throws Exception {
    BlockingQueue<String> bQueue = new BlockingQueue<String>(5);
    Thread producer = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("Producer Started");
        for(int ii = 0; ii < 100; ii++) {
          try {
            bQueue.push("STRING" + ii);
          } catch(InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
        System.out.println("Producer Finished");
      }
    });
    Thread consumer = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("Consumer Started");
        try {
          for(int ii = 0; ii < 100; ii++) {
            // System.out.println(bQueue.pop());
            bQueue.pop();
          }
        } catch(InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        System.out.println("Consumer Finished");
      }
    });
    consumer.start();
    producer.start();
    System.out.println("Done");
  }
}
