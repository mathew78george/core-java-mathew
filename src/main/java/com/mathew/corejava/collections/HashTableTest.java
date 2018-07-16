package com.mathew.corejava.collections;

import java.util.Hashtable;
import java.util.Map;

public class HashTableTest {

  public static void main(String[] args) {
    int [] tab = new int [100];
    for(int ii = 0; ii < tab.length; ii++) {
      tab [ii] = ii;
    }
    int hash ="myobject".hashCode();
    int index = (hash & 0x7FFFFFFF) % tab.length;
    Hashtable<Integer, String> HT = new Hashtable<Integer, String>();
    HT.put(null, "ONE");
    HT.put(2, "TWO");
    HT.put(3, "THREE");
//    System.out.println(index);
//    System.out.println(0x7FFFFFFF);
//    System.out.println(hash & 0x7FFFFFFF);
//    System.out.println(Integer.MAX_VALUE);
//    System.out.println(Integer.MIN_VALUE);
    int max = (int) Math.pow(2, 32);
    System.out.println(max);
  }
  public static void main2(String[] args) {

    Map<String, Integer> map = new Hashtable<String, Integer>();
    HashTableThread t1 = new HashTableThread(map, "Thread1");
    HashTableThread t2 = new HashTableThread(map, "Thread2");
    HashTableThread t3 = new HashTableThread(map, "Thread3");
    HashTableThread t4 = new HashTableThread(map, "Thread4");
    t1.start();
    t2.start();
    t3.start();
    t4.start();
    try {
     t1.join();
     t2.join();
     t3.join();
     t4.join();
    } catch(InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("Done-->"+map.size());

  }

}

class HashTableThread extends Thread {
  private Map<String, Integer> myHT;
  private String threadName;

  public HashTableThread(Map<String, Integer> ht, String thName) {
    myHT = ht;
    threadName = thName;
  }

  public void run() {
    for(int ii = 0; ii < 50000; ii++) {
      myHT.put("Key" + threadName + ii, new Integer(ii));
    }
    System.out.println(threadName+ "Done");
  }

}
