package com.mathew.corejava.algorithms;

public class BubbleSort {

  public static void doBubbleSortAscenting(int[] values) {
    assert values != null : "Empty Array";
    int length = values.length;
    int temp;
    for(int ii = 0; ii < length; ii++) {
      boolean flag = false;
      for(int jj = 0; jj < length - ii - 1; jj++) {
        if(values[jj] > values[jj + 1]) {
          temp = values[jj];
          values[jj] = values[jj + 1];
          values[jj + 1] = temp;
          flag = true;
        }
      }
      if(!flag) {
        System.out.println("breaking loop");
        break;
      }
    }
    for(int item : values) {
      System.out.print(item + ", ");
    }
  }

  public static void doBubbleSortDescenting(int[] values) {
    assert values != null : "Empty Array";
    int length = values.length;
    int temp;
    int loopcount = 0;
    int outerloopcount = 0;
    int innerloopcount = 0;
    for(int ii = 0; ii < length; ii++) {
      loopcount++;
      outerloopcount++;
      for(int jj = 0; jj < length - ii - 1; jj++) {
        loopcount++;
        innerloopcount++;
        if(values[jj] < values[jj + 1]) {
          temp = values[jj];
          values[jj] = values[jj + 1];
          values[jj + 1] = temp;
        }
      }
    }
    System.out.println("loopcount -->" + loopcount);
    System.out.println("outerloopcount -->" + outerloopcount);
    System.out.println("innerloopcount -->" + innerloopcount);
    for(int item : values) {
      System.out.print(item + ", ");
    }
  }

  public static void main(String[] args) {
     int[] values = { 5, 1, 6, 2, 4, 3, 8, 6, 11, 10, 9, 21, 22, 11, 17 };
//     int[] values = { 1, 2, 3, 4, 5, 6, 6, 8, 9, 10, 11, 11, 17, 21, 22 };
//    int[] values = { 1, 2, 3, 4, 5, 6, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
    doBubbleSortAscenting(values);
    System.out.println("\n");
    doBubbleSortDescenting(values);
  }

}
