package com.mathew.corejava.general;

public class VarSwapping {

  public static void main1(String[] args) {

    int a = 100;
    int b = 200;
    System.out.println("--a--" + a);
    System.out.println("--b--" + b);
    a = a + b;
    b = a - b;
    a = a - b;
    System.out.println("--a--" + a);
    System.out.println("--b--" + b);
    
    String s1 = "ONEONENENENENENENNENENNENENE";
    String s2 = "QQWQWQWQWQWQWQWQWQWQWQWQ";
    s1 = s1+s2;
    s2 = s1.substring(0,s1.length()-s2.length());
    s1 = s1.substring(s2.length(),s1.length());
    System.out.println(s2);
    System.out.println(s1);
  }
  
  public static void main(String[] args) {
    sortArray();
  }
  public static void main2(String[] args) {
    int[] input = new int[]{1, 1, 3, 7, 7, 8, 9, 9, 9, 10};
    int current = input[0];
    boolean found = false;

    for (int i = 0; i < input.length; i++) {
        if (current == input[i] && !found) {
            found = true;
        } else if (current != input[i]) {
            System.out.print(" " + current);
            current = input[i];
            found = false;
        }
    }
    System.out.print(" " + current);
  }
  
  public static void sortArray(){
    int[] input = {78,5,6,89,8,0,1,2,5,9,11,0,66,23,4,6,722};
    for (int ii = 0; ii < input.length; ii++){
      for (int jj = ii+1; jj <input.length; jj++){
        if(input [ii] > input[jj]){
          int temp = input[jj];
          input[jj] = input [ii];
          input [ii]= temp;          
        }
      }
    }
    for(int ii = 0; ii <input.length; ii++){
      System.out.print(input [ii]+",");
    }
  }

}
