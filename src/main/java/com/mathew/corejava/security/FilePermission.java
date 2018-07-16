package com.mathew.corejava.security;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.AccessControlContext;

public class FilePermission {

  public static void main(String[] args) {
    System.out.println("Starting");
    SecurityManager secManager = System.getSecurityManager();
    AccessControlContext context = (AccessControlContext) secManager.getSecurityContext();
    try {
      FileInputStream fip = new FileInputStream("C:/learningworkspace/mapreduceexamples/playlist.txt");
      // FileInputStream fip = new
      // FileInputStream("C:/learningworkspace/corejava/bin/words.txt");
      int i = 0;
      while((i = fip.read()) != -1) {
        System.out.println(i);
      }

    } catch(FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch(IOException ioe) {
      ioe.printStackTrace();
    }
    System.out.println("Ending");
  }

}
