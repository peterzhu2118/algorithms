package ca.peterzhu.algorithms;

/**
 * Class that sorts using insertion sort. Insertion sort works by adding
 * elements to a subarray in their correct positions.
 * 
 * Time Complexity - Best Case (Already sorted): O(n)
 * 
 * Time Complexity - Worst Case: O(n^2)
 * 
 * Time Complexity - Average Case: O(n^2)
 * 
 * @author Peter
 * 
 */
public class InsertionSort {
	/**
	 * Sorts the passed in array using insertion sort.
	 * 
	 * 
	 * @param arr
	 *            sorts this array
	 */
	public static void sort(int[] arr) {
		// Loop through the array.
		for (int i = 1; i < arr.length; i++) {
			int x = i;
			// While x is larger than 0 and the element before x is larger than
			// x, swap the two values. Swap the sign on the second part to sort
			// in ascending order.
			while (x > 0 && arr[x - 1] > arr[x]) {
				int temp = arr[x];
				arr[x] = arr[x - 1];
				arr[x - 1] = temp;

				// Decrease x.
				x--;
			}
		}
	}
}
