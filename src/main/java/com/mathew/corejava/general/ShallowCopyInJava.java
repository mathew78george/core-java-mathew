package com.mathew.corejava.general;

public class ShallowCopyInJava {

  public static void main(String[] args) {
    Student s1 = new Student("Mathew", "IPS", new Course("ML", "Data Scient"));
    Student s2 = null;
    try {
       s2 = (Student) s1.clone();
       System.out.println(s2.getCourse().getCourseName());
       System.out.println(s1.getCourse().getCourseName());
       s2.getCourse().setCourseName("Changed ML");
       System.out.println(s1.getCourse().getCourseName());
    } catch(CloneNotSupportedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
