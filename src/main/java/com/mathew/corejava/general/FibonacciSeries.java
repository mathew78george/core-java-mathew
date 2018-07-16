package com.mathew.corejava.general;

public class FibonacciSeries {

  private static void fiboSeries1(int count) {
    if(count == 1 || count == 2) {
      System.out.println("1");
    }
    System.out.print("1, 1,");
    int fib1 = 1;
    int fib2 = 1;
    for(int ii = 3; ii <= count; ii++) {
      int fib = fib1 + fib2;
      fib1 = fib2;
      fib2 = fib;
      System.out.print(fib + ",");
    }
  }

  private static void fiboSeries2(int number) {
    for(int i = 1; i <= number; i++) {
      System.out.print(fibonacci(i) + " ");
    }

  }

  public static int fibonacci(int number) {
    if(number == 1 || number == 2) { return 1; }

    return fibonacci(number - 1) + fibonacci(number - 2); // tail recursion
  }

  public static void main(String[] args) {
    fiboSeries2(6);
  }

}
