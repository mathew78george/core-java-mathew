package com.mathew.corejava.general;

import java.util.HashSet;
import java.util.Set;

public class DuplicateElementsInArray {

  static String[] strArray = new String[] { "AB", "AB", "AD", "CC", "BB", "CC", "AD", "MAMAMA" };

  public static void main(String[] args) {
    approach2();
  }

  static void approach1() {
    /*
     * =((N*(V-1))/2)+N-1 -- O(n^2)
     */
    int outerloop = 0;
    int innerloop = 0;
    for(int ii = 0; ii < strArray.length - 1; ii++) {
      outerloop++;
      for(int jj = ii + 1; jj < strArray.length; jj++) {
        innerloop++;
        if(strArray[ii].equals(strArray[jj])) {
          System.out.println("duplicate :" + strArray[jj]);
        }
      }
      // ?System.out.println("Inner Loop"+innerloop);
      // innerloop = 0;
    }
    System.out.println("Loop Count " + (outerloop + innerloop));
  }
  
  static void approach2() {
   Set<String> stringSet = new HashSet<String>();
   for(String aStr : strArray) {
     if(!stringSet.add(aStr)){
       System.out.println("duplicate"+aStr);
     }
   }
   
  }
}
