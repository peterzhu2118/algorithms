package ca.peterzhu.algorithms;

public class KMPPatternMatch {
	public static int search(String text, String pattern) {
		int[] arr = buildArray(pattern);
		int counter = 0;

		for (int i = 0; i < text.length(); i++) {
			// If the current character is equal to the counter character in the
			// pattern
			if (text.charAt(i) == pattern.charAt(counter)) {
				counter++;

				// If the end of the pattern is reached then the location is
				// returned
				if (counter >= pattern.length()) {
					return (i - counter) + 1;
				}
			} else if (counter > 0) {
				// If a different character is reached then reset the counter
				// and start searching from the current character
				counter = arr[counter - 1];
				i--;
			}
		}

		return -1;
	}

	/**
	 * Helper method to compute the array of repeats for the pattern.
	 * 
	 * @param pattern
	 *            the string to compute
	 * @return an integer array of repeats in the pattern
	 */
	private static int[] buildArray(String pattern) {
		int j = 0, i = 1;
		int[] result = new int[pattern.length()];

		while (true) {
			// If the array has been completely built, break out of it
			if (i == result.length) {
				break;
			} else if (pattern.charAt(j) == pattern.charAt(i)) {
				// If the character at j is the same as i, then the ending is
				// still the same as the beginning so increase both counters
				result[i] = ++j;
				i++;
			} else if (j > 0) {
				// If the character at j is not the same as i and j has a value
				// (i.e. i and j were previously the same) then j starts at the
				// value of the one before j
				j = result[j - 1];
			} else {
				// If there are and were no matches, then increment i
				i++;
			}
		}

		return result;
	}
}
