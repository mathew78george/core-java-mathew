package com.mathew.corejava.collections;

import java.util.ArrayList;
import java.util.List;

public class SetImpl<T> {

	private SetItem<T>[] elements;
	private int bucketSize;
	private static final int DEFAULT_BUCKET_SIZE = 10;
	private int count;

	public SetImpl() {
		elements = new SetItem[DEFAULT_BUCKET_SIZE];
		bucketSize = DEFAULT_BUCKET_SIZE;
	}

	public void add(T element) {
		if (count >= bucketSize * 0.6) {
			resize();
		}
		int index = element.hashCode() % bucketSize;
		if (index < 0)
			index = index * -1;
		SetItem<T> item = elements[index];
		if (item == null) {
			SetItem<T> newItem = new SetItem<T>(element);
			elements[index] = newItem;
		} else {
			MySetItemIterator<T> iter = new MySetItemIterator<T>(item);
			SetItem<T> tail = null;
			while (iter.hasNext()) {
				tail = iter.next();
				if (tail.getElement().equals(element) && tail.getElement().hashCode() == element.hashCode()) {
					System.out.println("Duplicate");
					return;
				}
			}
			SetItem<T> newItem = new SetItem<T>(element);
			tail.setNext(newItem);
		}
		count++;
	}

	private synchronized void resize() {
		SetItem<T>[] oldelements = elements;
		bucketSize = bucketSize * 2;
		SetItem<T>[] newelements = new SetItem[bucketSize];
		for (SetItem<T> item : oldelements) {
			if (item != null) {
				int index = item.getElement().hashCode() % bucketSize;
				if (index < 0) {
					index = index * -1;
				}
				SetItem anItem = newelements[index];
				if (anItem == null) {
					newelements[index] = item;
				} else {
					MySetItemIterator<T> iter = new MySetItemIterator<T>(anItem);
					SetItem<T> tail = null;
					while (iter.hasNext()) {
						tail = iter.next();
					}
					tail.setNext(item);
				}
			}
		}
		elements = newelements;
	}

	private synchronized void resize1() {
		List<SetItem<T>> oldItems = new ArrayList<SetItem<T>>();
		SetItem<T>[] oldelements = elements;
		bucketSize = bucketSize * 2;
		SetItem<T>[] newelements = new SetItem[bucketSize];
		for (SetItem<T> item : oldelements) {
			if (item != null) {
				MySetItemIterator<T> iter = new MySetItemIterator<T>(item);
				while (iter.hasNext()) {
					SetItem<T> anItem = iter.next();
					// anItem.setNext(null);
					oldItems.add(anItem);
				}
			}
		}
		for (SetItem<T> oldItem : oldItems) {
			int index = oldItem.getElement().hashCode() % bucketSize;
			if (index < 0) {
				index = index * -1;
			}
			SetItem<T> anItem = newelements[index];
			if (anItem == null) {
				newelements[index] = oldItem;
			} else {
				MySetItemIterator<T> iter = new MySetItemIterator<T>(anItem);
				SetItem<T> tail = null;
				while (iter.hasNext()) {
					tail = iter.next();
				}
				tail.setNext(anItem);
			}
		}
		elements = newelements;
	}

	public void printElements() {
		for (SetItem<T> item : elements) {
			MySetItemIterator<T> iter = new MySetItemIterator<T>(item);
			while (iter.hasNext()) {
				SetItem<T> tail = iter.next();
				System.out.println(tail.getElement());
			}
		}
	}

	public static void main(String[] args) {
		SetImpl<String> set = new SetImpl<String>();
		System.out.println("Start");
		for (int ii = 0; ii < 5000; ii++) {
			set.add("Element" + ii);
		}
		// set.add("Element" + 20);
		// set.add("Element" + 20);
		// set.add("Element" + 30);
		// set.add("Element" + 40);
		// set.add("Element" + 95);
		// set.add("Element" + 96);
		set.printElements();
		System.out.println(set.count);
	}

	public static void main1(String[] args) {
		SetItem<String> item1 = new SetItem<String>("One");
		SetItem<String> item2 = new SetItem<String>("Two");
		SetItem<String> item3 = new SetItem<String>("Three");
		SetItem<String> item4 = new SetItem<String>("Four");
		SetItem<String> item5 = new SetItem<String>("Five");
		SetItem<String> item6 = new SetItem<String>("Six");
		item1.setNext(item2);
		item2.setNext(item3);
		item3.setNext(item4);
		item4.setNext(item5);
		item5.setNext(item6);
		MySetItemIterator iter = new MySetItemIterator(item1);
		while (iter.hasNext()) {
			SetItem item = iter.next();
			System.out.println(item.getElement());
		}
	}

}

class SetItem<T> {
	T element;
	SetItem<T> next;

	public SetItem(T value) {
		element = value;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public SetItem<T> getNext() {
		return next;
	}

	public void setNext(SetItem<T> n) {
		next = n;
	}
}

class MySetItemIterator<T> {
	private SetItem<T> currentItem;

	public MySetItemIterator(SetItem<T> it) {
		currentItem = it;

	}

	public boolean hasNext() {
		if (currentItem == null) {
			return false;
		}
		return true;
	}

	public SetItem next() {
		SetItem temp = currentItem;
		currentItem = temp.getNext();
		return temp;
	}

	public T value() {
		return currentItem.getElement();
	}
}