package ca.peterzhu.algorithms;

/**
 * Binary search searches by recursively splitting a sorted array in half until
 * the desired element is found. Must be searching in a sorted array.
 * 
 * Time complexity (Average): O(log n)
 * 
 * @author Peter Zhu
 * 
 */
public class BinarySearch {
	/**
	 * @param arr
	 *            the array to search in. Must be sorted
	 * @param value
	 *            the value to search for
	 * @return the position of the value in the array, -1 if it does not exist.
	 */
	public static int search(int[] arr, int value) {
		return search(arr, value, 0, arr.length);
	}

	/**
	 * @param arr
	 *            the array to search in. Must be sorted
	 * @param value
	 *            the value to search for
	 * @param min
	 *            the minimum value
	 * @param max
	 *            the maximum value
	 * @return the position of the value in the array, -1 if it does not exist.
	 */
	private static int search(int[] arr, int value, int min, int max) {
		// If the search is narrowed down to one element and that element is not
		// what we are looking for, that element does not exist so -1 is
		// returned.
		if (min + 1 == max && arr[min] != value) {
			return -1;
		}

		// Middle value
		int mid = (min + max) / 2;

		// If the value is less than the middle element, then it can only be on
		// the left side.
		if (value < arr[mid]) {
			return search(arr, value, min, mid);
			// If the value is greater than the middle element, then it can only
			// be on the right side.
		} else if (value > arr[mid]) {
			return search(arr, value, mid, max);
			// Otherwise the value we are searching for is in the middle point
			// and we return it.
		} else {
			return mid;
		}
	}
}
