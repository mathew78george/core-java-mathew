package com.mathew.corejava.collections;

public class ListImpl<E> {

	private Object[] elements;
	private static final int DEFAULT_CAPACITY = 5;
	private int count;
	private int capacity;

	public ListImpl() {
		capacity = DEFAULT_CAPACITY;
		elements = new Object[capacity];
		count = 0;
	}

	public ListImpl(int cap) {
		capacity = cap;
		elements = new Object[capacity];
		count = 0;
	}

	public E get(int idx) {
		if (idx < 0 || idx >= count) {
			return null;
		}
		return (E) elements[idx];
	}

	public void add(E e) {
		if (count >= capacity * 0.7) {
			resize();
		}
		elements[count++] = e;
	}

	public boolean remove(int idx) {
		if (idx < 0 || idx >= count) {
			return false;
		}
		for (int ii = idx; ii < count; ii++) {
			elements[ii] = elements[ii + 1];
		}
		return true;

	}

	private synchronized void resize() {
		capacity = capacity * 2;
		Object[] tem = elements;
		elements = new Object[capacity];
		System.arraycopy(tem, 0, elements, 0, tem.length);
	}

	public static void main(String[] args) {
		ListImpl<String> lst = new ListImpl<String>();
		for (int ii = 0; ii < 20; ii++) {
			lst.add("" + ii);
		}
		lst.remove(22);
	}

}
