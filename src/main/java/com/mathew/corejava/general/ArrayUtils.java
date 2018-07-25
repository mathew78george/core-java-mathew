package com.mathew.corejava.general;

import java.util.Arrays;

public class ArrayUtils {

	static void miniMaxSum(int[] arr) {
		Arrays.sort(arr);
		int min = arr[0];
		int max = arr[arr.length - 1];
		int minsum = (arr.length * (arr.length + 1)) / 2 - min;
		int maxsum = (arr.length * (arr.length + 1)) / 2 - max;
		System.out.println(maxsum + " " + minsum);

	}

	static long aVeryBigSum(long[] arr) {
		long sum = ((arr[0] + arr[arr.length - 1]) * arr.length) / 2;
		return sum;

	}

	public static void main(String[] args) {
//		miniMaxSum(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 });
		System.out.println(aVeryBigSum(new long[] { 1000000001, 1000000002, 1000000003, 1000000004, 1000000005 }));
		System.err.println("sasasasas");
	}

}
