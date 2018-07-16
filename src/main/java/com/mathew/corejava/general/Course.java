package com.mathew.corejava.general;

public class Course {
  private String courseName;
  private String subject;

  Course(String c, String s) {
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

}
