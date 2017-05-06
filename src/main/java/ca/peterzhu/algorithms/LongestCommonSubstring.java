package ca.peterzhu.algorithms;

public class LongestCommonSubstring {
	public static Result compute(String str1, String str2) {
		int[][] arr = new int[str2.length() + 1][str1.length() + 1];

		int maxVal = -1, posX = -1, posY = -1;

		// Loops through the array.
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				// If the current characters are the same from the two Strings
				// then the current value is the value from the top left (i.e.
				// the length of the common substring excluding this character)
				// plus one.
				if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
					arr[i][j] = arr[i - 1][j - 1] + 1;

					// If the current value is larger than the previous largest
					// value then replace it with this.
					if (arr[i][j] > maxVal) {
						maxVal = arr[i][j];
						posX = i;
						posY = j;
					}
				}
			}
		}

		Result r = new Result();

		StringBuilder temp = new StringBuilder();

		// While the maximum value is greater than 0, add this character to the
		// StringBuilder and move to the previous character (top left corner).
		while (maxVal > 0) {
			temp.append(str2.charAt(posX - 1));

			posX--;
			posY--;
			maxVal--;
		}

		// Reverse because it is reversed.
		r.str = temp.reverse().toString();

		r.str2Loc = posX;
		r.str1Loc = posY;

		return r;
	}

	public static class Result {
		int str1Loc, str2Loc;
		String str;

		Result() {
			str = "";
		}

		@Override
		public String toString() {
			return "Location 1: " + str1Loc + " Location 2: " + str2Loc
					+ " String: " + str;
		}

		public int getStr1Loc() {
			return str1Loc;
		}

		public int getStr2Loc() {
			return str2Loc;
		}

		public String getStr() {
			return str;
		}
	}
}
