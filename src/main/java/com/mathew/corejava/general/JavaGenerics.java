package com.mathew.corejava.general;

import java.util.Arrays;

public class JavaGenerics {

  public static <E> void printArray(E[] array) {
    for(E element : array) {
      System.out.printf("%s ", element);
    }
  }

  public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
    T max = x;
    if(y.compareTo(max) > 0) {
      max = y;
    }
    if(z.compareTo(max) > 0) {
      max = z;
    }
    return max;
  }

  public static <T extends Comparable<T>> T maximum(T[] array) {
    T max = array[0];
    for(T element : array) {
      if(element.compareTo(max) > 0) {
        max = element;
      }
    }
    return max;
  }

  private static void maxArrayTest() {
    Integer[] intArray = new Integer[] { 100, 2, 4, 11, 1, 88, 89, 56, 16, 302, 7, 11, 9, 108 };
    System.out.printf("Max is %d\n", maximum(intArray));
    Double[] doubleArray = { 1.1, 88.8, 2.2, 3.3, 4.4, 6.2, 8.8, 2.0, 110.7, 13.7, 22.9, 25.2, 13.7 };
    System.out.printf("Max is %.1f", maximum(doubleArray));
  }

  private static void maxTest() {
    System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5, maximum(3, 4, 5));

    System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n", 6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7));

    System.out.printf("Max of %s, %s and %s is %s\n", "pear", "apple", "orange", maximum("pear", "apple", "orange"));
  }

  private static void printArrayTest() {
    // Create arrays of Integer, Double and Character
    Integer[] intArray = { 1, 2, 3, 4, 5 };
    Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
    Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

    System.out.println("Array integerArray contains:");
    printArray(intArray); // pass an Integer array

    System.out.println("\nArray doubleArray contains:");
    printArray(doubleArray); // pass a Double array

    System.out.println("\nArray characterArray contains:");
    printArray(charArray); // pass a Character array
  }

  public static void main(String args[]) {
    // maxTest();
    maxArrayTest();
    Box<String> strBox = new Box<String>();
    strBox.setObject("String Box");
    System.out.println(strBox.getObject());
  }

}

class Box<T> {
  private T object;

  public T getObject() {
    return object;
  }

  public void setObject(T obj) {
    object = obj;
  }
}
