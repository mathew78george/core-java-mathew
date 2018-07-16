package com.mathew.corejava.security;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.AccessControlException;

public class EnableSecurityManager {

  public static void main(String[] args) {
    System.setProperty("java.home", "myjavahome");
    System.out.println("java home--->" + System.getProperty("java.home"));
    SecurityManager secManager = new MySecurityManager();
    System.setSecurityManager(secManager);
    try {
      System.setProperty("java.home", "myjavahome111");
    } catch(AccessControlException ae) {
      System.out.println(ae.getLocalizedMessage());
    }
    try {
      FileInputStream fip = new FileInputStream("C:/learningworkspace/mapreduceexamples/playlist.txt");
      // FileInputStream fip = new
      // FileInputStream("C:/learningworkspace/corejava/bin/words.txt");
      int i = 0;
      while((i = fip.read()) != -1) {
        System.out.println(i);
      }
    } catch(SecurityException ae) {
      System.out.println(ae.getLocalizedMessage());
    } catch(FileNotFoundException foe) {

    } catch(IOException ioe) {

    }
  }
}

class MySecurityManager extends SecurityManager {

  public void checkRead(String file) {
    System.out.println("Inside MySecurityManager checkRead");
    if(!file.endsWith(".txt")) { throw new SecurityException("No Read Permission for :" + file); }
  }

}
