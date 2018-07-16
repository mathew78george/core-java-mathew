package com.mathew.corejava.general;

public class DCStudent implements Cloneable {

  private String name;
  private String department;
  private DCCourse course;

  DCStudent(String n, String d, DCCourse c) {
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

  public DCCourse getCourse() {
    return course;
  }

  public void setCourse(DCCourse course) {
    this.course = course;
  }

  protected Object clone() throws CloneNotSupportedException {
    DCStudent student = (DCStudent) super.clone();
    student.course = (DCCourse) this.course.clone();
    return student;
  }

}
