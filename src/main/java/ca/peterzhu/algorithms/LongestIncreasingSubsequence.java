package ca.peterzhu.algorithms;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	private LongestIncreasingSubsequence() {

	}

	public static int[] compute(int[] nums) {
		int[] table = new int[nums.length];
		int[] backtrack = new int[nums.length];
		// The maximum length and location where the maximum location begins
		int max = 0, maxLoc = -1;
		// Initialize the arrays
		Arrays.fill(table, 1);
		Arrays.fill(backtrack, -1);

		for (int i = 1; i < table.length; i++) {
			for (int j = 0; j < i; j++) {
				// If the value at j is less than the value at i and the length
				// of the increasing subsequence is as long or longer at j than
				// i then the current value in the table will be equal to the
				// value at j plus 1 (increased the length) and the current
				// increasing subsequence includes the value at position j so j
				// is added to the backtrack table
				if (nums[j] < nums[i] && table[j] >= table[i]) {
					table[i] = table[j] + 1;
					backtrack[i] = j;
				}

				// If this current value is larger than the maximum then replace
				// the maximum with this value
				if (table[i] > max) {
					max = table[i];
					maxLoc = i;
				}
			}
		}

		int prev = maxLoc;
		int[] result = new int[max];
		// Backtracks to find the numbers forming the subsequence
		for (int i = max - 1; i >= 0; i--) {
			result[i] = nums[prev];
			prev = backtrack[prev];
		}

		return result;
	}
}
