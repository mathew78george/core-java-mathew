package com.mathew.corejava.general;

public class StringRotation {

  public static void main1(String[] args) {
    String s1 = "OKABCABC";
    String s2 = "CBACBAK1O";
    StringBuffer buff1 = new StringBuffer(s1);
    if(s2.equals(buff1.reverse().toString())) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
    System.out.println(10110101 / 10);
    System.out.println(10110101 % 10);
  }

  static boolean isBinaryNumber(int number) {
    int copyNumber = number;
    boolean isBinary = true;
    while(copyNumber != 0) {
      int temp = copyNumber % 10;
      if(temp > 1) {
//        System.out.println("not a binary");
        isBinary = false;
        break;
      }
      copyNumber = copyNumber / 10;
    }
    System.out.println(isBinary);
    return isBinary;
  }

  public static void main(String[] args) {
    isBinaryNumber(128956);

    isBinaryNumber((101110));

    isBinaryNumber((42578));

    isBinaryNumber((10110101));
  }
}
