package com.mathew.corejava.general;

public class DCCourse implements Cloneable {
  private String courseName;
  private String subject;

  DCCourse(String c, String s) {
    courseName = c;
    subject = s;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
