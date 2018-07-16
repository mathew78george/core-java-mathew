package com.mathew.corejava.algorithms;

public class MySingleLinkedList {

  private SingleLLNode head = null;
  private int count = 0;

  public MySingleLinkedList() {

  }

  public void addFist(Object d) {
    SingleLLNode temp = head;
    head = new SingleLLNode(d, temp);
    count++;
  }

  public void addLast(Object d) {
    if(head == null) {
      SingleLLNode node = new SingleLLNode(d, null);
      head = node;
    } else {
      SingleLLNode temp = head;
      while(temp.next != null) {
        temp = temp.next;
      }
      SingleLLNode node = new SingleLLNode(d, null);
      temp.next = node;
    }
    count++;
  }

  public void clear() {
    head = null;
  }

  public void addAt(Object d, int index) {
    if(head == null) {
      SingleLLNode node = new SingleLLNode(d, null);
      head = node;
    } else {
      SingleLLNode temp = head;
      for(int i = 1; i < index && temp.next != null; i++) {
        temp = temp.next;
      }
      SingleLLNode holder = temp.next;
      SingleLLNode nextnode = new SingleLLNode(d, holder);
      temp.next = nextnode;
//      temp.next.next = holder;
    }
  }

  public void printLinkedLis() {
    SingleLLNode temphead = head;
    if(temphead == null) {
      System.out.println("Empty List");
    } else {
      while(temphead.data != null) {
        SingleLLNode node = temphead;
        System.out.println(node.data);
        temphead = node.next;
        if(temphead == null) {
          break;
        }
      }
    }
  }

  class SingleLLNode {

    private Object data;
    private SingleLLNode next;

    SingleLLNode(Object d, SingleLLNode n) {
      data = d;
      next = n;
    }

  }

  public static void main(String[] args) {
    MySingleLinkedList lst = new MySingleLinkedList();
    lst.addFist("1");
    lst.addFist("2");
    lst.addFist("3");
    lst.addFist("4");
    lst.addFist("5");
    lst.addFist("6");
    lst.addFist("8");
    lst.addAt("7", 7);
    lst.printLinkedLis();
    // System.out.println("=====================================");
    // lst.clear();
    //
    // lst.addLast("Mathew");
    // lst.addLast("Mathew111");
    // lst.addLast("Mathew21212");
    // lst.addLast("Mathe212121w");
    //
    // lst.printLinkedLis();
    // // lst.printLinkedLis();
  }
}
