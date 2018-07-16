package com.mathew.corejava.general;

import java.util.HashMap;
import java.util.Map;

public class MissingElementsInSeries {

  static int n = 8;

  static int[] arr = { 1, 4, 5, 3, 7, 8, 6 };

  public static void main(String[] args) {
    int[] array1 = populateArray(10000000, 800);
    approach1(array1);
//    approach2(array1);
  }

  static void approach1(int[] array) {
    long t1 = System.currentTimeMillis();
    Map<Integer, String> map = new HashMap<Integer, String>();
    for(int a : array) {
      map.put(a, "VAL");
    }
    for(int ii = 1; ii <= array.length; ii++) {
      if(!map.containsKey(ii)) {
        System.out.println("Missing Number is approach1 " + ii);
      }
    }
    long t2 = System.currentTimeMillis();
    System.out.println("Time Taken Approach 1"+(t2-t1));
  }

  static void approach2(int[] array) {
    long t1 = System.currentTimeMillis();
    int n = array.length;
    long sumOfNumbers = (n * (n + 1)) / 2;
    long sumOfArray = 0;
    for(int i = 0; i < array.length; i++) {
      sumOfArray = sumOfArray + array[i];
    }
    long missingNumber = sumOfNumbers - sumOfArray;
    System.out.println("Missing Number is approach2" + missingNumber);
    long t2 = System.currentTimeMillis();
    System.out.println("Time Taken Approach 2"+(t2-t1));
  }

  static int[] populateArray(int size, int missingIndes) {
    int[] array = new int[size];
    for(int ii = 0; ii < size; ii++) {
      if(ii != missingIndes) array[ii] = ii + 1;
    }
    return array;
  }
}
