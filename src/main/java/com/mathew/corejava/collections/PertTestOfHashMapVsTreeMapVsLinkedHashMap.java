package com.mathew.corejava.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class PertTestOfHashMapVsTreeMapVsLinkedHashMap {
  private static final int[] COUNT1 = new int[] { 10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 900000 };
  private static final int[] COUNT = new int[] { 900000, 900000, 900000, 900000, 900000, 900000, 900000, 900000,
      900000, 900000, 900000, 900000, 900000, 900000, 900000, 900000, 900000, 900000, 900000, 900000, 900000, 900000,
      900000 };

  public static void main(String[] args) {
    for(int ii = 0; ii < COUNT.length - 1; ii++) {
      System.out.println("====================================================================");
      Map<Integer, Integer> HMap = new HashMap<Integer, Integer>(900000);
      Map<Integer, Integer> TreeMap = new TreeMap<Integer, Integer>();
      Map<Integer, Integer> linjedHMap = new LinkedHashMap<Integer, Integer>();
      testInsertion(HMap, COUNT[ii]);
      long t1 = System.nanoTime();
      HMap.get(COUNT[ii]-1000);
      System.out.println("Get time HMap "+(System.nanoTime() - t1));
       HMap = null;
      testInsertion(TreeMap, COUNT[ii]);
      t1 = System.nanoTime();
      TreeMap.get(COUNT[ii]-1000);
      System.out.println("Get time TreeMap "+(System.nanoTime() - t1));
      TreeMap = null;
      testInsertion(linjedHMap, COUNT[ii]);
      t1 = System.nanoTime();
      linjedHMap.get(COUNT[ii]-1000);
      System.out.println("Get time linjedHMap "+(System.nanoTime() - t1));
      linjedHMap = null;
      System.out.println("====================================================================");
    }
    System.out.println("Done");
  }

  static void testInsertion(Map<Integer, Integer> map, int count) {
    System.out.println("Map Implementation is " + map.getClass().getName());
    long t1 = System.currentTimeMillis();
    for(int i = 0; i < count; i++) {
      map.put(i, i);
    }
    System.out.println("Insertion time for " + count + " elements is " + (System.currentTimeMillis() - t1));
  }

}
