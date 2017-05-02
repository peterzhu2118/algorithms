package ca.peterzhu.algorithms;

/**
 * Linear search loops through every element in the array and compares that
 * element to the desired element to be searched for.
 * 
 * Time complexity (Average): O(n)
 * 
 * @author Peter Zhu
 * 
 */
public class LinearSearch {
	/**
	 * 
	 * @param arr
	 *            the array to search
	 * @param value
	 *            the value to search
	 * @return the position of the value in the array, -1 if it does not exist.
	 */
	public static int search(int[] arr, int value) {
		// Loop through every element in the array.
		for (int i = 0; i < arr.length; i++) {
			// If the current value in the array is the element we are searching
			// for, return the position (i).
			if (arr[i] == value) {
				return i;
			}
		}

		// If there are no matches return -1.
		return -1;
	}
}
