package com.mathew.corejava.collections;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapTest {
  public static void main(String[] args) {
    Map<Order,Integer> map = new WeakHashMap<Order, Integer>();
    map.put(new Order(1, "Order 1"), 100);
    map.put(new Order(2, "Order 1"), 100);
    map.put(new Order(3, "Order 1"), 100);
    map.put(new Order(4, "Order 1"), 100);
    System.out.println(map.size());
    System.gc();
    System.out.println(map.size()); 
  }

}

class Order {
  private int orderId;
  private String details;

  public Order(int anId, String det) {
    orderId = anId;
    details = det;
  }
}
