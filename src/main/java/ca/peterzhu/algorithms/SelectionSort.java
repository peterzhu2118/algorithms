package ca.peterzhu.algorithms;

/**
 * Class that sorts using selection sort. Selection sort works by looping
 * through the array and looks for the smallest (or largest for descending)
 * element and swaps it with the current element.
 * 
 * Time Complexity - Best and Worst Case: O(n^2)
 * 
 * @author Peter Zhu
 * 
 */
public class SelectionSort {
	/**
	 * Sorts the passed in array using selection sort.
	 * 
	 * @param arr
	 *            sorts this array
	 */
	public static void sort(int[] arr) {
		// Loop through every element in the array. Does not need to run for the
		// last element since a single element is always sorted.
		for (int i = 0; i < arr.length - 1; i++) {
			// Set the current smallest value to be at i.
			int minPos = i;
			// Loop through the array starting at the next from the i value.
			for (int x = i + 1; x < arr.length; x++) {
				// If the value at x is smaller than the current smallest value,
				// set the position of the smallest value to the minimum
				// position variable. Flip this sign to sort the other way.
				if (arr[x] < arr[minPos]) {
					minPos = x;
				}
			}

			// Swap the values between the value at i and the smallest value.
			int temp = arr[minPos];
			arr[minPos] = arr[i];
			arr[i] = temp;
		}
	}
}
