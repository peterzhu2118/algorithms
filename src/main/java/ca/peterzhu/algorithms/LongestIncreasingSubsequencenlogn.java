package ca.peterzhu.algorithms;

import java.util.Arrays;

public class LongestIncreasingSubsequencenlogn {
	public static int[] compute(int[] nums) {
		int len = 0;
		int[] temp = new int[nums.length];
		int[] result = new int[nums.length];
		// Fill the result array with -1 (i.e. no result)
		Arrays.fill(result, -1);

		for (int i = 1; i < nums.length; i++) {
			// If the current value is larger than the largest value in the
			// array
			if (nums[temp[len]] < nums[i]) {
				len++;
				temp[len] = i;
				result[i] = temp[len - 1];
			} else { // Else find the ceiling for the current value in the
						// array. Replace that value with the current value.
				int ciel = ceiling(nums[i], len, temp, nums);
				temp[ciel] = i;
				if (ciel > 0)
					result[i] = temp[ciel - 1];
			}
		}

		int[] ans = new int[len + 1];
		int pos = temp[len];

		// Backtrack to find the longest increasing subsequence. Uses the result
		// array.
		for (int i = len; i >= 0; i--) {
			ans[i] = nums[pos];
			pos = result[pos];
		}

		return ans;
	}

	/**
	 * Calculates the ceiling for the value given (i.e. the location where the
	 * first value larger than this value is).
	 * 
	 * @param val
	 *            the value to search
	 * @param len
	 *            the length of the location array
	 * @param loc
	 *            the location array
	 * @param vals
	 *            values for the location array
	 * @return the position of the ceiling
	 */
	private static int ceiling(int val, int len, int[] loc, int[] vals) {
		int[] search = new int[len];

		for (int i = 0; i < len; i++) {
			search[i] = vals[loc[i]];
		}

		int binSearch = Arrays.binarySearch(search, val);

		return binSearch >= 0 ? binSearch + 1 : -1 * (binSearch + 1);
	}
}
