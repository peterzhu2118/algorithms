package ca.peterzhu.algorithms;

import java.util.Arrays;

/**
 * Merge sort with insertion sort for smaller arrays.
 * 
 * Time Complexity (Average): O(n log n)
 * 
 * @author Peter Zhu
 * 
 */
public class MergeSortWithInsertion {
	/**
	 * 
	 * @param arr
	 *            the array to be sorted
	 * @return the sorted array
	 */
	public static int[] sort(int[] arr) {
		// If the size is less than 8 we can use insertion sort instead.
		if (arr.length < 8) {
			InsertionSort.sort(arr);
			return arr;
		} else {
			// The max and mid points of the array.
			int max = arr.length;
			int mid = max / 2;

			// Split the array into two parts and sort them individually.
			int[] left = sort(Arrays.copyOfRange(arr, 0, mid));
			int[] right = sort(Arrays.copyOfRange(arr, mid, max));

			// Create the merged array and the two counters.
			int[] sortedArr = new int[max];
			int leftCounter = 0;
			int rightCounter = 0;

			for (int i = 0; i < sortedArr.length; i++) {
				// If there are still values on the left and the right side,
				// then compare them and select the smallest.
				if (leftCounter < left.length && rightCounter < right.length) {
					if (left[leftCounter] < right[rightCounter]) {
						sortedArr[i] = left[leftCounter];
						leftCounter++;
					} else {
						sortedArr[i] = right[rightCounter];
						rightCounter++;
					}
				} else if (leftCounter < left.length) { // If there is only the
														// left side left.
					sortedArr[i] = left[leftCounter];
					leftCounter++;
				} else if (rightCounter < right.length) { // If there is only
															// the right side
															// left.
					sortedArr[i] = right[rightCounter];
					rightCounter++;
				}
			}

			return sortedArr;
		}
	}
}
