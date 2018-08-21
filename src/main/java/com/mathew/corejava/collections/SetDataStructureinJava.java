package com.mathew.corejava.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Time Complexity - Hasset - Add, Remove, Contains - O(1)
 * Time Complexity - Treeset - Add, Remove, Contains O(log(n));
 * Time Complexity - O (1)
 * @author U0117078
 *
 */

public class SetDataStructureinJava {

	public static void main(String[] args) {
		 testHashSet();
		 System.out.println("===============================");
		 testTreeSet();
		 System.out.println("===============================");
		testLinkedHashSet();
		performanceTest();
	}

	public static void testHashSet() {
		Set<Dog> hashSet = new HashSet<Dog>();
		Dog d1 = new Dog(1, "Dog 1");
		Dog d2 = new Dog(2, "Dog 2");
		Dog d3 = new Dog(5, "Dog 5");
		Dog d4 = new Dog(3, "Dog 3");
		Dog d5 = new Dog(8, "Dog 8");
		Dog d6 = new Dog(6, "Dog 6");
		Dog d7 = new Dog(1, "Dog 1");
		Dog d8 = new Dog(4, "Dog 4");
		Dog d9 = new Dog(7, "Dog 7");
		hashSet.add(d1);
		hashSet.add(d2);
		hashSet.add(d3);
		hashSet.add(d4);
		hashSet.add(d5);
		hashSet.add(d6);
		hashSet.add(d7);
		hashSet.add(d8);
		hashSet.add(d9);
		Iterator<Dog> iterator = hashSet.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	public static void testTreeSet() {
		SortedSet<Dog> hashSet = new TreeSet<Dog>();
		Dog d1 = new Dog(1, "Dog 1");
		Dog d2 = new Dog(2, "Dog 2");
		Dog d3 = new Dog(5, "Dog 5");
		Dog d4 = new Dog(3, "Dog 3");
		Dog d5 = new Dog(8, "Dog 8");
		Dog d6 = new Dog(6, "Dog 6");
		Dog d7 = new Dog(1, "Dog 1");
		Dog d8 = new Dog(4, "Dog 4");
		Dog d9 = new Dog(7, "Dog 7");
		hashSet.add(d1);
		hashSet.add(d2);
		hashSet.add(d3);
		hashSet.add(d4);
		hashSet.add(d5);
		hashSet.add(d6);
		hashSet.add(d7);
		hashSet.add(d8);
		hashSet.add(d9);
		Iterator<Dog> iterator = hashSet.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	public static void testLinkedHashSet() {
		Set<Dog> hashSet = new LinkedHashSet<Dog>();
		Dog d1 = new Dog(1, "Dog 1");
		Dog d2 = new Dog(2, "Dog 2");
		Dog d3 = new Dog(5, "Dog 5");
		Dog d4 = new Dog(3, "Dog 3");
		Dog d5 = new Dog(8, "Dog 8");
		Dog d6 = new Dog(6, "Dog 6");
		Dog d7 = new Dog(1, "Dog 1");
		Dog d8 = new Dog(4, "Dog 4");
		Dog d9 = new Dog(7, "Dog 7");
		hashSet.add(d1);
		hashSet.add(d2);
		hashSet.add(d3);
		hashSet.add(d4);
		hashSet.add(d5);
		hashSet.add(d6);
		hashSet.add(d7);
		hashSet.add(d8);
		hashSet.add(d9);
		Iterator<Dog> iterator = hashSet.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	public static void performanceTest() {
		int loopSize = 900000;
		Set<Dog> hashset = new HashSet<Dog>();
		Set<Dog> treeset = new TreeSet<Dog>();
		Set<Dog> linkedhashset = new TreeSet<Dog>();
		Random r = new Random();
		long starttime = System.currentTimeMillis();
		for (int ii = 0; ii <loopSize; ii++) {
			int x = r.nextInt(loopSize - 10) + 10;
			String n = "Dog"+x+ii;
			Dog d = new Dog(x,n);
			hashset.add(d);
		}
		long endtime = System.currentTimeMillis();
		System.out.println("Time taken HashSet--->"+(endtime-starttime)/60);
		starttime = System.currentTimeMillis();
		for (int ii = 0; ii <loopSize; ii++) {
			int x = r.nextInt(loopSize - 10) + 10;
			String n = "Dog"+x+ii;
			Dog d = new Dog(x,n);
			treeset.add(d);
		}
		endtime = System.currentTimeMillis();
		System.out.println("Time taken TreeSet---> "+(endtime-starttime)/60);
		starttime = System.currentTimeMillis();
		for (int ii = 0; ii <loopSize; ii++) {
			int x = r.nextInt(loopSize - 10) + 10;
			String n = "Dog"+x+ii;
			Dog d = new Dog(x,n);
			linkedhashset.add(d);
		}
		endtime = System.currentTimeMillis();
		System.out.println("Time taken LinkedHashSet--->"+(endtime-starttime)/60);
	}

}

class Dog implements Comparable<Dog> {
	int size;
	String name;

	public Dog(int s, String n) {
		size = s;
		name = n;
	}

	public String toString() {
		return "[name = " + name + " Size = " + size + "]";
	}

	@Override
	public int compareTo(Dog o) {
		return size - o.size;
	}

	@Override
	public boolean equals(Object o) {
		Dog other = (Dog) o;
		if (other == this) {
			return true;
		}
		if (name.equals(other.name) && size == other.size) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode()) + size;
		return result;
	}
}