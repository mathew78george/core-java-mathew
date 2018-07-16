package com.mathew.corejava.collections;

import java.util.ArrayList;
import java.util.List;

public class ListImplementationTests {

  public static void main(String[] args) {
    
//    arrayListInsertionTest();
    arrayListRemoveInsertTest();
//    List<String> llobj = new LinkedList<String>();
//    llobj.add("1. Alive is  awesome");
//    llobj.add("2. Love yourself");
//    System.out.println("LinkedList object output :" + llobj);
//    llobj.get(0);    
    
  }
  
  static void arrayListInsertionTest(){
    /**
     * Default initial size is 10.
     * Insertion is On(N) if Array is full, otherwise it is O(1)
     * ArrayList uses dynamic array Implementation
     * 
     */
    List<String> arrlistobj = new ArrayList<String>();
    arrlistobj.add("1. Alive is awesome");
    arrlistobj.add("2. Love yourself");
    arrlistobj.add("2. Love yourself");
    arrlistobj.add("2. Love yourself");
    arrlistobj.add("2. Love yourself");
    arrlistobj.add("2. Love yourself");
    arrlistobj.add("2. Love yourself");
    arrlistobj.add("2. Love yourself");
    arrlistobj.add("2. Love yourself");
    arrlistobj.add("2. Love yourself");
    
    System.out.println("ArrayList object output size:" + arrlistobj.size());
    arrlistobj.add("11. Love yourself");
    String str = arrlistobj.get(5);
    System.out.println("STR---"+str);
    
    List<String> arrlistobjNew = new ArrayList<String>(100);
    arrlistobjNew.add("1. Alive is awesome");
    arrlistobjNew.add("2. Love yourself");
    arrlistobjNew.add("2. Love yourself");
    arrlistobjNew.add("2. Love yourself");
    arrlistobjNew.add("2. Love yourself");
    arrlistobjNew.add("2. Love yourself");
    arrlistobjNew.add("2. Love yourself");
    arrlistobjNew.add("2. Love yourself");
    arrlistobjNew.add("2. Love yourself");
    arrlistobjNew.add("2. Love yourself");
    arrlistobjNew.add("2. Love yourself");
  }
  
  static void arrayListGetTest(){
    /**
     * Get is always O(1)
     */
    List<String> arrlistobj = new ArrayList<String>();
    arrlistobj.add("1. Alive is awesome");
    arrlistobj.add("2. Love yourself");
    arrlistobj.add("2. Love yourself");
    arrlistobj.add("2. Love yourself");
    arrlistobj.add("2. Love yourself");
    arrlistobj.add("2. Love yourself");
    arrlistobj.add("2. Love yourself");
    arrlistobj.add("2. Love yourself");
    arrlistobj.add("2. Love yourself");
    arrlistobj.add("2. Love yourself");
    arrlistobj.get(5);
    arrlistobj.get(0);
  }
  
  static void arrayListRemoveInsertTest(){
    /**
     * Insert to in between needs array copy (bit shift)
     * ADD(index, Object) is more expensive because it always needs array copy to ensure continues indices and order (O(N)
     * ADD(Object) may need array copy if array is full (O(N) or O(1)
     * Remove is O(N)
     * Remove(index) - need system array copy
     * Remove(Object) - need system array copy + element iteration to find object
     */
    List<String> arrlistobj = new ArrayList<String>(100);
    for(int ii = 0; ii <100; ii++){
      arrlistobj.add("1. Alive is awesome"+ii);
    }
    arrlistobj.add(90, "1. Alive is awesomeinsert90");
    arrlistobj.remove(88);
    arrlistobj.remove("1. Alive is awesomeinsert90");
  }

}
