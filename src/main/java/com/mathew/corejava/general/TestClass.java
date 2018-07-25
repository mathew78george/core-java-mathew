package com.mathew.corejava.general;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class TestClass {
	static int j = 10;

	public static void main(String[] args) {
		List<String> aList = new ArrayList<String>();
		aList.add("A");
		aList.add(0, "B");
		aList.add(0, "C");
		System.out.println(aList.size());
	}

	public void throwrte() {
		System.out.println("throwrte");
		throw new RuntimeException();
	}

	public static void throwError() {
		throw new Error();
	}

	public void method4(String[] args) {
		try {
			throwError();
		} catch (Exception e) {

		} finally {
			System.out.println("finally.....");
		}
		System.out.println("done");
	}

	public void method3(String[] args) {
		try {
			TestClass test = new TestClass();
			test.throwrte();
		} catch (Exception e) {
			System.out.println("exception");
		} finally {
			System.out.println("finally");
		}
		System.out.println("done");
	}

	public void method2(String[] args) {
		TestClass test = new TestClass();
		long a[] = new long[] { 10, 20, 30 };
		long[] b = test.fix(a);
		System.out.println(a[0] + a[1] + a[2]);
		System.out.println(b[0] + b[1] + b[2]);
		int x = 100;
		test.method1(x);
		System.out.println(x);
		System.out.println(j);
	}

	public void method1(int i) {
		i = i * 2;
		j = j * 2;
	}

	public long[] fix(long[] a) {
		a[1] = 40;
		return a;
	}

	public static void fizzBuzz() {
		Scanner s = new Scanner(System.in);
		int testcase = Integer.parseInt(s.nextLine());
		System.out.println("Hi testcase, " + testcase + ".");
		int[] tests = new int[testcase];
		String[] testStr = s.nextLine().split(" ");
		s.close();
		for (int ii = 0; ii < testStr.length; ii++) {
			tests[ii] = Integer.parseInt(testStr[ii]);
		}
		for (int jj = 0; jj < tests.length; jj++) {
			for (int ii = 1; ii <= tests[jj]; ii++) {
				if (ii % 3 == 0 && ii % 5 == 0) {
					System.out.println("FizzBuzz");
				} else if (ii % 3 == 0) {
					System.out.println("Fizz");
				} else if (ii % 5 == 0) {
					System.out.println("Buzz");
				} else {
					System.out.println(ii);
				}
			}

		}
	}

}
