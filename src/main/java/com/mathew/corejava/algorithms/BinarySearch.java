package com.mathew.corejava.algorithms;

import java.util.Arrays;
import java.util.Collections;

public class BinarySearch {

	public static int doBinarySearch(Integer[] values, int target) {
		int len = values.length;
		int start = 0;
		int end = len - 1;
		while (end >= start) {
			int mid = (start + end) / 2;
			if (target == values[mid]) {
				return mid;
			}
			if (target < values[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static int binarySerach(Integer[] values, int target) {
		int start = 0;
		int end = values.length - 1;
		while (end >= start) {
			int mid = (start + end) / 2;
			if (values[mid] == target) {
				return mid;
			}
			if (target < values[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Integer[] values = { 3, 2, 8, 7, 4, 12, 43, 10, 6, 5, 22, 21, 18, 17, 26, 11, 14, 16, 33, 17, 27, 19 };
		Collections.sort(Arrays.asList(values));
		// System.out.println(values);
		// int index = doBinarySearch(values, 10);
		// System.out.println("Index is doBinarySearch " + index);
		int index = binarySerach(values, 10);
		System.out.println("Index is binarySerach " + index);
	}

}
