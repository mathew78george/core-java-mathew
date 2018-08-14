package com.mathew.corejava.general;

import java.util.HashMap;
import java.util.Hashtable;

public class TestHashCollission {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(new Integer(1),"ONE");
		map.put(new Integer(2),"TWO");
		map.put(new Integer(3),"THREE");
		map.put(new Integer(4),"FOUR");
		map.put(new Integer(5),"FIVE");
		map.put(null,"FIVE2121");
		
		System.out.println("Value = "+map.get(new Integer(1)));
		System.out.println("Value = "+map.get(new Integer(1)));
		System.out.println("Value = "+map.get(new Integer(1)));
		System.out.println("Value = "+map.get(new Integer(1)));
		System.out.println("Value = "+map.get(new Integer(1)));
		System.out.println("Value = "+map.get(null));
		int index = 118 & 15;
		System.out.println(index);
		Hashtable<String, String> HT = new Hashtable<String, String>();
		HT.put("ONE", "tetete");
		HT.put("two", "tetete");
		HT.put("three", "tetete");
		HT.put("four", "tetete");
		System.out.println("sasasasasasasasasa");
		
	}
	public static void main1(String[] args) {
		HashMap<Person, String> map = new HashMap<Person, String>();
		Person p1 = new Person(1, "ABC");
		Person p2 = new Person(2, "DEF");
		Person p3 = new Person(1, "XYZ");
		Person p4 = new Person(1, "PQR");
		Person p5 = new Person(1, "PQR");
		map.put(p1,"ONE");
		map.put(p2,"TWO");
		map.put(p3,"THREE");
		map.put(p4,"FOUR");
		map.put(p5,"FIVE");
		System.out.println("\nComplete Map entries \n" + map);
		System.out.println("Value = "+map.get(p1));
		System.out.println("Value = " + map.get(p2));
		System.out.println("Value = " + map.get(p3));
		System.out.println("Value = " + map.get(p4));
		System.out.println("Value = " + map.get(p5));
	}

}

class Person {

	private int id;

	private String name;

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int hashCode() {
//		System.out.println("called hashCode for =" + id + "." + name);
		return id;
	}

	public boolean equals(Object obj) {
//		System.out.println("called equals on =" + id + "." + name + "  to compare with  = " + ((Person) obj).getId()
//				+ "." + ((Person) obj).getName());
		boolean result = false;
		if (obj instanceof Person) {
			if (((Person) obj).getId() == id && ((Person) obj).getName().equals(name))
				result = true;
		}
		return result;
	}

	public String toString() {
		return  id+"";
	}

}