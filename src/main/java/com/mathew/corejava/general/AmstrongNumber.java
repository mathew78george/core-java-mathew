package com.mathew.corejava.general;

public class AmstrongNumber { 

  static boolean isAmstrongNumber1(int number) {
    boolean isAmstrong = false;
    int copyNumber = number;
    int digits = String.valueOf(number).length();
    int sum = 0;
    while(copyNumber != 0) {
      int lastDigit = copyNumber % 10;
      int temp = 1;
      for(int ii = 1; ii <= digits; ii++) {
        temp = temp * lastDigit;
      }
      sum = sum + temp;
      copyNumber = copyNumber / 10;
    }
    if(sum == number) {
      System.out.println(number + " is Amstrong");
      isAmstrong = true;
    }
    return isAmstrong;
  }

  static boolean isAmstrongNumber2(int number) {
    boolean isAmstrong = false;
    int digits = String.valueOf(number).length();
    String tempStr = Integer.toString(number);
    int[] digitsArr = new int[digits];
    for(int ii = 0; ii < digits; ii++) {
      digitsArr[ii] = tempStr.charAt(ii) - '0';
    }
    int sum = 0;
    for(int jj = 0; jj < digits; jj++) {
      int n = digitsArr[jj];
      int temp = 1;
      for(int ii = 1; ii <= digits; ii++) {
        temp = temp * n;
      }
      sum = sum + temp;
    }
    if(sum == number) {
      System.out.println(number + " is Amstrong");
      isAmstrong = true;
    }
    return isAmstrong;
  }

  public static void main(String[] args) { 
    System.out.println(isAmstrongNumber2(153));
    System.out.println(isAmstrongNumber2(9474));
//    intToIntArray1(123456);
//    intToIntArray2(1234562121);

  }

  static void intToIntArray2(int number) {
    int len = String.valueOf(number).length();
    int[] array = new int[len];
    int copyNumber = number;
    while(copyNumber != 0) {
      int temp = copyNumber % 10;
      array[len - 1] = temp;
      len--;
      copyNumber = copyNumber / 10;
    }
    for(int ii = 0; ii < array.length; ii++) {
      System.out.print(array[ii] + " ");
    }
  }

  static void intToIntArray1(int number) {
    int len = String.valueOf(number).length();
    int[] array = new int[len];
    String str = Integer.toString(number);
    for(int ii = 0; ii < len; ii++) {
      array[ii] = str.charAt(ii) - '0';
    }
    for(int ii = 0; ii < array.length; ii++) {
      System.out.print(array[ii] + " ");
    }

  }

}
