package com.mathew.corejava.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {

  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<String, Integer>();
    map = Collections.synchronizedMap(map);
    map.put("ABSBB", 100);
    map.put("KGGAA", 1002);
    map.put("asasasa", 1030);
    map.put("LLLL", 1070);
    map.put("AAAAB", 108880);
    Iterator iter = map.keySet().iterator();
    while(iter.hasNext()) {
      System.out.println(map.get(iter.next()));
      map.put("sasasa", 10000);
    }
  }
}

class HashMapThread extends Thread {
  private Map<String, Integer> myHT;
  private String threadName;

  public HashMapThread(Map<String, Integer> ht, String thName) {
    myHT = ht;
    threadName = thName;
  }

  public void run() {
    for(int ii = 0; ii < 50000; ii++) {
      myHT.put("Key" + threadName + ii, new Integer(ii));
    }
    System.out.println(threadName + "Done");
  }
}
