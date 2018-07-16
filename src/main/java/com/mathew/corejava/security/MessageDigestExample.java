package com.mathew.corejava.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestExample {

  public static void main(String[] args) {
    try {
      String data = " This is a data need to be encrypted";
      MessageDigest digest = MessageDigest.getInstance("MD5");
      digest.update(data.getBytes());
      byte[] encrypted = digest.digest();
      StringBuffer stringBuffer = new StringBuffer();
      for(byte bytes : encrypted) {
        stringBuffer.append(String.format("%02x", bytes & 0xff));
      }
      System.out.println(stringBuffer.toString());
    } catch(NoSuchAlgorithmException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
