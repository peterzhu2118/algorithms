package ca.peterzhu.algorithms;

import java.util.ArrayList;
import java.util.List;

public class RodCutting {
	/**
	 * @param length
	 *            the length of the rod
	 * @param prices
	 *            an array of the length and the price
	 * @return a list of the optimal lengths to cut
	 */
	public static List<Integer> compute(int length, int[][] prices) {
		int[][] arr = new int[prices.length][length + 1];

		

		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				// Value of using one above (i.e. lesser value lengths)
				int val1 = i - 1 >= 0 ? arr[i - 1][j] : 0;
				// Current length value if it is possible
				int val2 = j >= prices[i][0] ? prices[i][1]
						+ arr[i][j - prices[i][0]] : 0;

				// Compares the values to get the larger one and assign it into
				// the array
				arr[i][j] = Integer.max(val1, val2);
			}
		}

		// To backtrack for the answer, start at the bottom right corner
		int locX = arr.length - 1, locY = arr[locX].length - 1;
		List<Integer> result = new ArrayList<Integer>();
		// Backtracks to find the lengths needed
		while (true) {
			// If the location of the size is 0 or less
			if (locY <= 0) {
				break;
			}

			// If the current value is taken from above
			if (locX - 1 >= 0 && arr[locX][locY] == arr[locX - 1][locY]) {
				locX--;
				continue;
			} else { // Else this value is part of result
				result.add(prices[locX][0]);
				locY -= prices[locX][0];
			}
		}

		return result;
	}
}
