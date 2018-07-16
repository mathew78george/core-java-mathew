package com.mathew.corejava.general;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CommonElementsInArray {

  static String[] strArray1 = { "ONE", "TWO", "THREE", "OK", "FOUR", "FIVE", "FOUR", "112", "Mathew", "0201021" };

  static String[] strArray2 = { "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "Mathew", "FOUR", "Mathew", "Geo", "OK" };

  public static void main(String[] args) {
    approach1();
    approach2();
    approach3();
  }

  static void approach1() {
    Set<String> commonStrs = new HashSet<String>();
    for(String str1 : strArray1) {
      for(String str2 : strArray2) {
        if(str1.equals(str2)) {
          commonStrs.add(str1);
        }
      }
    }
    System.out.println(commonStrs);
  }

  static void approach2() {
    Set<String> set1 = new HashSet<String>(Arrays.asList(strArray1));
    Set<String> set2 = new HashSet<String>(Arrays.asList(strArray2));
    set1.retainAll(set2);
    System.out.println(set1);
  }

  static void approach3() {
    Map<String, String> m1 = new HashMap<String, String>();
    Map<String, String> m2 = new HashMap<String, String>();
    for(String str1 : strArray1) {
      m1.put(str1, "VAL");
    }
    for(String str2 : strArray2) {
      if(m1.containsKey(str2)) {
        m2.put(str2, "VAL");
      } else {
        m1.put(str2, "VAL");
      }
    }
    System.out.println(m2.keySet());
  }

}
