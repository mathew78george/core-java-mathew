package com.mathew.corejava.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Vector;

public class ListInterfaceSamples {

  public static void main(String[] args) {
    List<Employee> elist = new ArrayList<Employee>();

    Employee e1 = new Employee(5, "Mathew");
    Employee e2 = new Employee(4, "Mathew");
    Employee e3 = new Employee(3, "Mathew");
    Employee e4 = new Employee(8, "Mathew");
    Employee e5 = new Employee(2, "Mathew");
    elist.add(e1);
    elist.add(e2);
    elist.add(e3);
    elist.add(e4);
    elist.add(e4);
    elist.add(e5);
    Collections.sort(elist);
    System.out.println(elist.get(0).getId());
  }

  public static void sample1(String[] args) {
    Queue<String> queue = new PriorityQueue<>();
    List<String> aList = new ArrayList<String>();
    List<String> lList = new LinkedList<String>();
    long t1 = System.currentTimeMillis();
    generateData(aList);
    long t2 = System.currentTimeMillis();
    System.out.println("ArrayList Insertion Time " + (t2 - t1) + " Size " + aList.size());
    t1 = System.currentTimeMillis();
    generateData(lList);
    t2 = System.currentTimeMillis();
    System.out.println("LinkedList Insertion Time " + (t2 - t1) + " Size " + lList.size());
    t1 = System.currentTimeMillis();
    aList.remove(100000);
    aList.remove(100001);
    aList.remove(100005);
    t2 = System.currentTimeMillis();
    System.out.println("ArrayList Removal Time " + (t2 - t1) + " Size " + aList.size());
    t1 = System.currentTimeMillis();
    lList.remove(100000);
    lList.remove(100001);
    lList.remove(100005);
    t2 = System.currentTimeMillis();
    System.out.println("LinkedList Removal Time " + (t2 - t1) + " Size " + lList.size());
    /*
     * try { Thread.sleep(1000000); } catch(InterruptedException e) { // TODO
     * Auto-generated catch block e.printStackTrace(); }
     */
  }

  private static void generateData(List<String> list) {
    for(int ii = 0; ii < 5000000; ii++) {
      list.add("STRING" + ii);
    }
  }

}

class Employee implements Comparable<Employee> {
  private int id;
  private String name;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Employee(int i, String n) {
    id = i;
    name = n;
  }

  public int compareTo(Employee e) {
    return ((Integer) this.id).compareTo((Integer) e.id);
  }

}
