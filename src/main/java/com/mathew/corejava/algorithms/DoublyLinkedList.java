package com.mathew.corejava.algorithms;

public class DoublyLinkedList {
  DLNode first = null;
  DLNode last = null;
  int modCount = 0;

  public DoublyLinkedList() {

  }

  public void addFirst(Object d) {
    DLNode newnode = new DLNode(d);
    if(modCount == 0) {
      first = newnode;
      last = newnode;
    } else {
      newnode.next = first;
      first.previous = newnode;
      first = newnode;
    }
    modCount++;
  }

  public void addLast(Object d) {
    DLNode newnode = new DLNode(d);
    if(modCount == 0) {
      first = newnode;
      last = newnode;
    } else {
      last.next = newnode;
      newnode.previous = last;
      last = newnode;
    }
    modCount++;
  }

  public void linkFirst(Object d) {
    final DLNode f = first;
    DLNode newnode = new DLNode(null, d, first);
    first = newnode;
    if(f == null) {
      last = newnode;
    } else {
      f.previous = newnode;
    }
  }

  public void linkLast(Object d) {
    final DLNode l = last;
    DLNode newnode = new DLNode(last, d, null);
    last = newnode;
    if(l == null) {
      first = newnode;
    } else {
      l.next = newnode;
    }
  }

  public DLListIterator forwardIterator() {
    return new DLListIterator();
  }

  class DLNode {

    DLNode previous;
    Object data;
    DLNode next;

    DLNode(Object element) {
      this.previous = null;
      this.data = element;
      this.next = null;
    }

    DLNode(DLNode prev, Object element, DLNode next) {
      this.previous = prev;
      this.data = element;
      this.next = next;
    }

  }

  class DLListIterator {
    private DLNode next = null;

    DLListIterator() {
      next = first;
    }

    public Object nextItem() {
      Object item = next.data;
      next = next.next;
      return item;
    }

  }

  public static void main(String[] args) {

    DoublyLinkedList llist = new DoublyLinkedList();
    llist.addFirst("AAA");
    llist.addFirst("BBB");
    llist.addFirst("CCC");
    llist.addFirst("DDD");
    llist.addFirst("EEE");
    DLListIterator fiter = llist.forwardIterator();
    for(int i = 0; i < 5; i++) {
      System.out.println(fiter.nextItem());
    }

  }

}
