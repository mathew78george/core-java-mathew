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

	public void remove1(E data) {
		int index = 0;
		for (LinkedListItem<E> x = head; x != null; x = x.getNext()) {
			index++;
			if (data.equals(x.getItem())) {
				break;
			}
		}
		LinkedListItem<E> current = head;
		for (int ii = 0; ii < index - 1; ii++) {
			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
	}

	public void remove(E data) {
		if (head == null) {
			return;
		}
		if (head.getItem().equals(data)) {
			if (size == 1) {
				head = null;
				tail = null;
				size--;
				return;
			} else {
				head = head.getNext();
				size--;
				return;
			}
		}
		LinkedListItem<E> temp = head;
		while (temp.getNext() != null && !temp.getNext().getItem().equals(data)) {
			temp = temp.getNext();
		}
		temp.setNext(temp.getNext().getNext());

	}

	public static void main(String[] args) {
		LinkedListImpl<String> ll = new LinkedListImpl<String>();
		ll.add("ONE");
		ll.add("TWO");
		ll.add("3");
		ll.add("4");
		ll.add("5");
		ll.add("6");
		ll.add("7");
		ll.remove("ONE");

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