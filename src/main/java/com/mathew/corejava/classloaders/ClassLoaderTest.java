package com.mathew.corejava.classloaders;

import com.mathew.corejava.classloaders.testclasses.Foo;

public class ClassLoaderTest {
  private String testing;
  static String test ="new test";
  static{
    System.out.println(test);
  }
  public static void main(String[] args) {
    System.out.println(ClassLoaderTest.class.getMethods());
    ClassLoaderTest t = new ClassLoaderTest();
    String test2="";
    int testint=1;
    System.out.println("class loader for HashMap: " + java.util.HashMap.class.getClassLoader());
    System.out.println("class loader for this class: " + ClassLoaderTest.class.getClassLoader());

    System.out.println(Foo.class.getClassLoader());
    
    String s1 = new String("Test");
    String s2 = new String("Test");
    System.out.println(s1==s2);
    
    String s3 = "Test";
    String s4 = "Test";
    System.out.println(s3==s4);
    System.out.println(testint);
    System.out.println(test2);
  }

}
