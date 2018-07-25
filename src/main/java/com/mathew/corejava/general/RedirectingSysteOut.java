package com.mathew.corejava.general;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

interface TestInterfae {

	public default void test() {
		System.out.println("Standard Out 1");
	}

	public static void test1() {
		System.out.println("Standard Out 1");
	}

	public abstract void test3();

}

public class RedirectingSysteOut implements TestInterfae {

	public void test3() {
		System.out.println("Test 3");
	}
	
	public void test() {
		System.out.println("Overriden defaultrp");
	}

	public static void main(String[] args) {
		try {
			TestInterfae test = new RedirectingSysteOut();
			test.test3();
			test.test();
			TestInterfae.test1();

			FileOutputStream foperror = new FileOutputStream("StandardError.txt", true);
			FileOutputStream fopstandard = new FileOutputStream("StandardOut.txt", true);
			FileInputStream fipstandard = new FileInputStream("InputSteam.txt");
			PrintStream outStream = new PrintStream(fopstandard);
			PrintStream errStream = new PrintStream(foperror);
			System.setOut(outStream);
			System.setErr(errStream);
			System.setIn(fipstandard);
			System.out.println("Standard Out 1");
			System.out.println("Standard Out 2");
			System.out.println("Standard Out 3");
			System.err.println("Standard Error 1");
			System.err.println("Standard Error 2");
			System.err.println("Standard Error 3");
			BufferedReader ipReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(ipReader.readLine());
			System.out.println(ipReader.readLine());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ioe) {

		}
	}
}
