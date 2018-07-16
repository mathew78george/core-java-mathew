package com.mathew.corejava.collections;

import java.util.ArrayList;
import java.util.LinkedList;

public class StringTest {
  static {
    System.out.println("String test");
  }
  public static void main1(String[] args) {
    String str1 = "StringObject";
    String str2 = "StringObject";
    System.out.println(str1 == str2);
    System.out.println(str1.equals(str2));
    str2 = "StringObjectChanged";
    System.out.println(str1 == str2);
    System.out.println(str1.equals(str2));
//    System.out.println(getReverseString(str2));
//    findLongestAndshortestWords(" Write annnn Program to print ascii value of each character of asaasassasasasasasasasasasas string. This is asasasa trial and error method. And not sure if it is going to yield rigt result in all conditionas...");
    String ascstr = "We are not in Kansas anymore";
    for(char c : ascstr.toCharArray()) {
      System.out.println((int)c);
    }
    System.out.println(String.valueOf(5));
//    LinkedList<E>
  }
  public static void main(String[] args) {
    
  }

  public static String getReverseString(String str) {

    if(str.length() <= 1) { return str; }

    return (getReverseString(str.substring(1)) + str.charAt(0));

  }

  private static void findLongestAndshortestWords(String aString) {
    String[] array = aString.trim().split(" ");
    String longStr = array[0], shortStr = array[0];
    int longLengh = array[0].length(), shortLengnth = array[0].length();
    for(String word : array) {
      if(word.length() > longLengh) {
        longLengh = word.length();
        longStr = word;
      }
      if(word.length() <= shortLengnth) {
        shortLengnth = word.length();
        shortStr = word;
      }
    }
    System.out.println("Shortest word " + shortStr);
    System.out.println("Longest word " + longStr);
  }
  @Override
  protected void finalize() throws Throwable {
    // TODO Auto-generated method stub
    super.finalize();
  }
}
