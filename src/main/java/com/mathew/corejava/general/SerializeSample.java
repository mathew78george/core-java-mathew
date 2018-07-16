package com.mathew.corejava.general;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeSample {
  public static void main(String[] args) {
    SerializeClass c1 = new SerializeClass("Mathew George", 10);
    String filename = "file.ser";
    FileOutputStream fop = null;
    ObjectOutputStream oop = null;
    FileInputStream fip = null;
    ObjectInputStream oip = null;
    try {
      fop = new FileOutputStream(filename);
      oop = new ObjectOutputStream(fop);
      oop.writeObject(c1);
      System.out.println("Serialization Done");
      fip = new FileInputStream(filename);
      oip = new ObjectInputStream(fip);
      SerializeClass c2 = (SerializeClass) oip.readObject();
      System.out.println(c2.getAge());
      System.out.println(c2.getName());
      System.out.println(c2.getTranInt());
      System.out.println(c2.statStr);
    } catch(FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch(IOException ioe) {
      ioe.printStackTrace();
    } catch(ClassNotFoundException ce) {
      ce.printStackTrace();
    } finally {
      try {
        fop.close();
        oop.close();
        fip.close();
        oip.close();
      } catch(IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}

class SerializeClass implements Serializable {

  private static final long serialVersionUID = 5360091826473809824L;
  private int age;
  private String name;
  public static String statStr = "Static String";
  private transient int transInt = 10;

  public SerializeClass() {
    System.out.println("22222222222222");
  }

  public SerializeClass(String n, int a) {
    this.age = a;
    this.name = n;
    transInt = 100;
    System.out.println("1111111111");
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getTranInt() {
    return transInt;
  }

}
