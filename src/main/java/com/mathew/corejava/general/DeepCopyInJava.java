package com.mathew.corejava.general;

public class DeepCopyInJava {
  
  public static void main(String[] args) {
    DCStudent s1 = new DCStudent("Mathew", "IPS", new DCCourse("ML", "Data Scient"));
    DCStudent s2 = null;
    try {
       s2 = (DCStudent) s1.clone();
       System.out.println(s2.getCourse().getCourseName());
       System.out.println(s1.getCourse().getCourseName());
       s2.getCourse().setCourseName("Changed ML");
       System.out.println(s1.getCourse().getCourseName());
       System.out.println(s2.getCourse().getCourseName());
    } catch(CloneNotSupportedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
