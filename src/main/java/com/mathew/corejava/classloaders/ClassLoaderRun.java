package com.mathew.corejava.classloaders;

import java.lang.reflect.Method;

import com.mathew.corejava.classloaders.testclasses.Foo;

public class ClassLoaderRun {
  
  public static void main3(String[] args) throws Exception{
    String progClass = "com.mathew.corejava.classloaders.testclasses.Foo";
    CustomClassLoader ccl = new CustomClassLoader(ClassLoaderRun.class.getClassLoader());
    Class clas = ccl.loadClass(progClass);
  }
  
  public static void main(String[] args) throws Exception{
    String progClass = "com.mathew.corejava.classloaders.testclasses.Foo";
    Class.forName(progClass);
    System.out.println("Done");
  }

  public static void main2(String args[]) throws Exception {
    String progClass = "com.mathew.corejava.classloaders.testclasses.Foo";
    String progArgs[] = new String[]{"1212", "1313"};
//    System.arraycopy(args, 1, progArgs, 0, progArgs.length);

    CustomClassLoader ccl = new CustomClassLoader(ClassLoaderRun.class.getClassLoader());
    Class clas = ccl.loadClass(progClass);
    Class mainArgType[] = { (new String[0]).getClass() };
    Method main = clas.getMethod("main", mainArgType);
    Object argsArray[] = { progArgs };
    main.invoke(null, argsArray);

    // Below method is used to check that the Foo is getting loaded
    // by our custom class loader i.e CCLoader
    Method printCL = clas.getMethod("printCL", null);
    printCL.invoke(null, new Object[0]);
  }
  
  public static void main1(String[] args) {
    CustomClassLoader ccl = new CustomClassLoader(ClassLoaderRun.class.getClassLoader());
    Foo foo = new Foo();
  }

}
