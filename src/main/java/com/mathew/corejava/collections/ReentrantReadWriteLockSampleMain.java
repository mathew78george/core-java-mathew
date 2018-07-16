package com.mathew.corejava.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockSampleMain {
  static final int READER_SIZE = 10;
  static final int WRITER_SIZE = 2;

  public static void main(String[] args) {
    Integer[] initialElements = { 33, 28, 86, 99 };
    ReentrantReadWriteLockSample<Integer> sharedList = new ReentrantReadWriteLockSample<Integer>();
    sharedList.initialize(initialElements);
    for(int i = 0; i < WRITER_SIZE; i++) {
      Thread thread = new Thread(new WriterThread(sharedList));
      thread.start();
    }

    for(int i = 0; i < READER_SIZE; i++) {
      Thread thread = new Thread(new ReaderThread(sharedList));
      thread.start();
    }

  }
}

class ReentrantReadWriteLockSample<E> {

  List<E> list = new ArrayList<>();
  ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
  Lock readLock = rwLock.readLock();
  Lock writeLock = rwLock.writeLock();

  public void initialize(E elements[]) {
    writeLock.lock();
    try {
      list.addAll(Arrays.asList(elements));
    } finally {
      writeLock.unlock();
    }
  }

  public void add(E element) {
    writeLock.lock();
    try {
      list.add(element);
    } finally {
      writeLock.unlock();
    }
  }

  public E get(int index) {
    readLock.lock();
    try {
      return list.get(index);
    } finally {
      readLock.unlock();
    }
  }

  public int size() {
    readLock.lock();
    try {
      return list.size();
    } finally {
      readLock.unlock();
    }
  }
}

class WriterThread implements Runnable {

  ReentrantReadWriteLockSample<Integer> sharedList = null;

  public WriterThread(ReentrantReadWriteLockSample<Integer> list) {
    sharedList = list;
  }

  @Override
  public void run() {

    Random random = new Random();
    int number = random.nextInt(100);
    sharedList.add(number);
    try {
      Thread.sleep(10);
    } catch(InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}

class ReaderThread implements Runnable {

  ReentrantReadWriteLockSample<Integer> sharedList = null;

  public ReaderThread(ReentrantReadWriteLockSample<Integer> list) {
    sharedList = list;
  }

  @Override
  public void run() {
    try {
      int size = sharedList.size();
      if(size > 0) {
        System.out.println("Value -->" + sharedList.get(size-1));
      }
      Thread.sleep(1000);
    } catch(InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
