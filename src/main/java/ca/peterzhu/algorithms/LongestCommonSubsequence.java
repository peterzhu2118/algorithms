package ca.peterzhu.algorithms;

public class LongestCommonSubsequence {
	private LongestCommonSubsequence(){
		
	}
	
	public static String compute(String str1, String str2) {
		int[][] table = new int[str2.length() + 1][str1.length() + 1];

		// Builds the array. If the characters in the two strings are the same
		// then this is the same as the value in the top left plus one. If the
		// two characters are not the same then it is the same as the max value
		// between the left and the top value.
		for (int i = 1; i < table.length; i++) {
			for (int x = 1; x < table[i].length; x++) {
				if (str2.charAt(i - 1) == str1.charAt(x - 1)) {
					table[i][x] = table[i - 1][x - 1] + 1;
				} else {
					table[i][x] = Integer.max(table[i - 1][x], table[i][x - 1]);
				}
			}
		}

		StringBuilder result = new StringBuilder();

		int xCoord = table.length - 1;
		int yCoord = table[xCoord].length - 1;

		// Backtracks to find the characters that make up this subsequence.
		while (true) {
			// If the end has been reached, break.
			if (table[xCoord][yCoord] == 0) {
				break;
			}

			// If the value comes from the top or the left, move there.
			if (table[xCoord][yCoord] == table[xCoord][yCoord - 1]) {
				yCoord--;
			} else if (table[xCoord][yCoord] == table[xCoord - 1][yCoord]) {
				xCoord--;
			} else {
				// If the value comes from the top left, then the current
				// character is part of the solution. Store the current values
				// of xCoord and yCoord to save the locations of the
				// subsequence.
				result.append(str2.charAt(xCoord - 1));
				xCoord--;
				yCoord--;
			}
		}

		return result.reverse().toString();
	}
}
