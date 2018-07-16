package com.mathew.corejava.algorithms;

public class PermuteAllListNumbers {

  public static void permute(int[] values, int start) {

    if(start == values.length) {
      for(int n = 0; n < values.length; n++) {
        System.out.print(" ["+values[n]+"] ");
      }
      System.out.println();
    } else {
      for(int i = start; i < values.length; i++) {
        int temp = values[start];
        values[start] = values[i];
        values[i] = temp;
        permute(values, start + 1);
        temp = values[start];
        values[start] = values[i];
        values[i] = temp;
      }
    }
  }

  public static void main(String[] args) {
    int[] sequence = new int[] { 15, 61, 16 };
//    permute(sequence, 0);
    String[][] stringArray = {{"Str1","Str2","Str3","Str4","Str5"}, {"abc","efg"}};
    System.out.println("Testtt--"+stringArray[1][1]);
  }
}
