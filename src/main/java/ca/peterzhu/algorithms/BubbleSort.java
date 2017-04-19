package ca.peterzhu.algorithms;

/**
 * Class on implementation of bubble sort. Bubble sort works by comparing all
 * the adjacent elements in an array and swapping them if needed and repeating
 * this process until no swaps are done in an iteration.
 * 
 * Time Complexity - Best Case: O(n) -> All elements are already sorted 
 * Time Complexity - Worst Case: O(n^2) -> Elements are not sorted
 * Time Complexity - Average: O(n^2)
 * 
 * Space Complexity: O(1)
 * 
 * @author Peter Zhu
 */
public class BubbleSort {
	/**
	 * Sorts the array passed in using bubble sort.
	 * 
	 * @param arr
	 *            the array to be sorted
	 */
	public static void sort(int[] arr) {
		boolean changed = true;

		// Keep on looping if there are changes. If there are no changes then
		// the array is sorted.
		while (changed) {
			changed = false;

			// Loop through every element in the array except for the last
			// element
			for (int i = 0; i < arr.length - 1; i++) {
				// If the current element is larger than the next element, swap
				// them.
				// Swap this sign to change from sorting ascending (small to
				// large) to descending (large to small).
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;

					// Set changed to true
					changed = true;
				}
			}
		}
	}
}
