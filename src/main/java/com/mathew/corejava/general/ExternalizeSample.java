package com.mathew.corejava.general;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ExternalizeSample {

  public static void main(String[] args) {
    Car c1 = new Car("Test", "New Test");
    c1.setName("Mercedez Benz");
    c1.setYear(2018);
    FileOutputStream fop = null;
    ObjectOutputStream oop = null;
    FileInputStream fip = null;
    ObjectInputStream oip = null;
    try {
      fop = new FileOutputStream("carfile.ser");
      oop = new ObjectOutputStream(fop);
      oop.writeObject(c1);
      fip = new FileInputStream("carfile.ser");
      oip = new ObjectInputStream(fip);
      Car c2 = (Car) oip.readObject();
      System.out.println(c2.mileage);
      System.out.println(c2.regNo);
      System.out.println(c2.name);
      System.out.println(c2.year);
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

class Automobile {

  /*
   * Instead of making thse members private and adding setter and getter
   * methods, I am just giving default access specifier. You can make them
   * private members and add setters and getters.
   */
  String regNo;
  String mileage;

  /*
   * A public no-arg constructor
   */
  public Automobile() {
  }

  Automobile(String rn, String m) {
    regNo = rn;
    mileage = m;
  }
}

class Car extends Automobile implements Externalizable {
  String name;
  int year;

  public Car() {

  }

  public Car(String n, String m) {
    super(n, m);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  @Override
  public void writeExternal(ObjectOutput out) throws IOException {
    System.out.println("writeExternal");
    out.writeObject(regNo);
    out.writeObject(mileage);
    out.writeInt(year);
    out.writeObject(name);

  }

  @Override
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    System.out.println("readExternal");
    regNo = (String) in.readObject();
    mileage = (String) in.readObject();
    year = in.readInt();
    name = (String) in.readObject();
  }
}
