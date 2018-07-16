package com.mathew.corejava.general;

public class Student implements java.lang.Cloneable {
  private String name;
  private String department;
  private Course course;

  Student(String n, String d, Course c) {
    name = n;
    department = d;
    course = c;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
