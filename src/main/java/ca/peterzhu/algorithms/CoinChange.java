package ca.peterzhu.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {
	private CoinChange() {

	}

	public static List<Integer> compute(int total, int[] coins) {
		int[] t = new int[total + 1];
		int[] result = new int[total + 1];

		// Fill the total array (which stores the number of coins needed for a
		// specific amount of change) with maximum values (infinite amount of
		// coins needed) and the result array with -1.
		Arrays.fill(t, Integer.MAX_VALUE);
		Arrays.fill(result, -1);

		t[0] = 0;

		for (int c = 0; c < coins.length; c++) {
			int currCoin = coins[c];
			for (int i = 0; i < t.length; i++) {
				// If the current coin can be added
				if (i >= currCoin) {
					// If change can be made while giving this coin
					if (t[i - currCoin] != Integer.MAX_VALUE) {
						// If adding this coin is more efficient than the
						// current solution, then change the solution to use
						// this and the result to this coin
						if (1 + t[i - currCoin] < t[i]) {
							t[i] = 1 + t[i - currCoin];
							result[i] = c;
						}
					}
				}
			}
		}

		// Stores the result
		List<Integer> r = new ArrayList<>();
		int currPos = result.length - 1;

		while (true) {
			r.add(coins[result[currPos]]);

			currPos -= coins[result[currPos]];

			// If 0 coin position is reached (no more change is needed), break.
			if (currPos == 0)
				break;
		}

		return r;
	}
}
