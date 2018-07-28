package com.mathew.corejava.designpatterns.observer;

import java.util.Observable;

public class MyObservable extends Observable {

	private int age;

	public MyObservable() {
		age = 10;
	}

	public void setAge(int a) {
		age = a;
		setChanged();
		notifyObservers();
	}

	public static void main(String[] args) {
		MyObservable ob = new MyObservable();
		MyObserver observer = new MyObserver();
		ob.addObserver(observer);
		ob.setAge(100);
	}

}
