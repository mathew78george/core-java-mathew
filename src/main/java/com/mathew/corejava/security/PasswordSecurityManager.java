package com.mathew.corejava.security;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PasswordSecurityManager extends SecurityManager {

  private String password;

  public PasswordSecurityManager(String pw) {
    password = pw;
  }

  public void checkRead(String file) {
    if(!accessOK()) { throw new SecurityException(
        " checkRead(String file) -- Access Denied to requested resource :" + file); }
    super.checkRead(file);

  }

  public void checkRead(FileDescriptor fd) {
    if(!accessOK()) { throw new SecurityException(
        " checkRead(FileDescriptor fd)-  Access Denied to requested resource :" + fd); }
    super.checkRead(fd);
  }

  public void checkRead(String file, Object context) {
    if(!accessOK()) { throw new SecurityException(
        "checkRead(String file, Object context) -- Access Denied to requested resource :"); }
    super.checkRead(file, context);
  }

  public void checkWrite(FileDescriptor filedescriptor) {
    if(!accessOK())
      throw new SecurityException("checkWrite(FileDescriptor filedescriptor) -- Access Denied to requested resource");
    super.checkRead(filedescriptor);
  }

  public void checkWrite(String filename) {
    if(!accessOK()) throw new SecurityException("checkWrite(String filename) -- Access Denied to requested resource");
    super.checkRead(filename);
  }

  private boolean accessOK() {
    boolean haveAccess = false;
    InputStreamReader dips = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(dips);
    System.out.println("Enter secret password");
    try {
      String response = reader.readLine();
      if(response.equals(password)) {
        haveAccess = true;
      }
    } catch(IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return haveAccess;
  }

  public static void main(String[] args) {
    PasswordSecurityManager secManager = new PasswordSecurityManager("angel");
    System.setSecurityManager(secManager);
    BufferedReader fip = null;
    BufferedWriter writer = null;
    String pathname = "C:/learningworkspace/mapreduceexamples/playlist.txt";
    try {

      fip = new BufferedReader(new FileReader(pathname));
      // FileInputStream fip = new
      // FileInputStream("C:/learningworkspace/corejava/bin/words.txt");
      String str = null;
      while((str = fip.readLine()) != null) {
        System.out.println(str);
      }
    } catch(SecurityException ae) {
      System.out.println(ae.getLocalizedMessage());
    } catch(FileNotFoundException foe) {
      System.out.println(foe.getLocalizedMessage());
    } catch(IOException ioe) {
      System.out.println(ioe.getLocalizedMessage());
    } finally {
      try {
        if(fip != null) fip.close();
      } catch(IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

    try {
      writer = new BufferedWriter(new FileWriter(pathname, true));
      writer.write("\n");
      writer.write("At the end of file \n");
    } catch(FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch(IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      try {
        if(writer != null) writer.close();
      } catch(IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

  }
}
