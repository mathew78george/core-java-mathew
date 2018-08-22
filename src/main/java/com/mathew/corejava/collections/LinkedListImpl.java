package com.mathew.corejava.collections;


public class LinkedListImpl<E> {

	private LinkedListItem<E> head;
	private LinkedListItem<E> tail;
	private int size;

	public LinkedListImpl() {

	}

	public void add(E data) {
		if (size == 0) {
			LinkedListItem<E> newItem = new LinkedListItem<E>(data, tail);
			head = newItem;
			size++;
			return;
		}
		LinkedListItem<E> newItem = new LinkedListItem<E>(data, null);
		if (tail == null) {
			tail = newItem;
			head.setNext(tail);
			return;
		}
		tail.setNext(newItem);
		tail = newItem;
		size++;
	}

	public void remove(E data) {
		for (LinkedListItem<E> x = head; x != null; x = x.getNext()) {
			LinkedListItem<E> previous = x;
			LinkedListItem<E> next = x.getNext();
			if (data.equals(x.getItem())) {
				previous.setItem(null);
				previous.setNext(next);
//				if (next != null) {
//					previous.setNext(next);
//				} else {
//					previous.setItem(null);
//					previous.setNext(null);
//				}
			}
		}
	}

	public static void main(String[] args) {
		LinkedListImpl<String> ll = new LinkedListImpl<String>();
		ll.add("ONE");
		ll.add("TWO");
		ll.add("3");
		ll.add("4");
		ll.remove("TWO");
		ll.add("TWO");
		ll.add("5");
		ll.add("6");
		
	}

}

class LinkedListItem<E> {

	private E item;
	private LinkedListItem<E> next;

	public LinkedListItem(E data, LinkedListItem<E> n) {
		item = data;
		next = n;
	}

	public E getItem() {
		return item;
	}

	public void setItem(E item) {
		this.item = item;
	}

	public LinkedListItem<E> getNext() {
		return next;
	}

	public void setNext(LinkedListItem<E> next) {
		this.next = next;
	}

}