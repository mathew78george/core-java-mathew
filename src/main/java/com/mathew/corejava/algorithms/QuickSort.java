package com.mathew.corejava.algorithms;

import java.util.Arrays;

public class QuickSort {

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = (low - 1); // index of smaller element
		for (int j = low; j < high; j++) {
			// If current element is smaller than or
			// equal to pivot
			if (arr[j] <= pivot) {
				i++;

				// swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// swap arr[i+1] and arr[high] (or pivot)
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	public static void quickSort(int[] array) {
		recursiveQuickSort(array, 0, array.length - 1);
	}

	public static void recursiveQuickSort(int[] array, int startIdx, int endIdx) {

		int idx = partition(array, startIdx, endIdx);

		// Recursively call quicksort with left part of the partitioned array
		if (startIdx < idx - 1) {
			recursiveQuickSort(array, startIdx, idx - 1);
		}

		// Recursively call quick sort with right part of the partitioned array
		if (endIdx > idx) {
			recursiveQuickSort(array, idx, endIdx);
		}
	}

	public static void main(String[] args) {
		int[] input = { 23, 31, 1, 21, 36, 72, 14, 3, 1, 88, 10, 16, 15, 27, 66, 34, 18 };
		System.out.println("Before sorting : " + Arrays.toString(input));
		quickSort(input); // sort the integer array using quick sort algorithm
		System.out.println("After sorting : " + Arrays.toString(input));

	}

}
