package ca.peterzhu.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * This class computes the minimum edit distance between 2 strings. There are 3
 * possible operations: adding, removing and replacing (NOT swapping) a
 * character with another.
 * 
 * @author Peter
 * 
 */
public class MinEditDistance {
	public static List<Operation> compute(String src, String dest) {
		int[][] arr = buildArray(src, dest);

		// Start at the bottom right for backtracking
		int xCoord = arr.length - 1, yCoord = arr[0].length - 1;

		// List of operations needed
		List<Operation> operations = new ArrayList<>();

		while (true) {
			// If the top or the left is reached, then the edits are done
			if (xCoord <= 0 || yCoord <= 0) {
				break;
			}

			// If the two characters are the same then no edits are needed and
			// the point is moved to the top left
			if (src.charAt(yCoord - 1) == dest.charAt(xCoord - 1)) {
				yCoord--;
				xCoord--;
				continue;
			}

			// Compare the values of left, top left and right to find the
			// smaller value
			int compare = min(arr[xCoord][yCoord - 1],
					arr[xCoord - 1][yCoord - 1], arr[xCoord - 1][yCoord]);

			// If the smallest value is from the left, then the remove operation
			// is used
			if (compare == 0) {
				yCoord--;
				operations.add(new Operation(yCoord, src.charAt(yCoord), -1,
						null));
			} else if (compare == 1) {
				// If the smallest value is from the top left, then the replace
				// operation is used
				xCoord--;
				yCoord--;
				operations.add(new Operation(yCoord, src.charAt(yCoord),
						xCoord, dest.charAt(xCoord)));
			} else if (compare == 2) {
				// If the smallest value is from the top, then the adding
				// operation is used
				xCoord--;
				operations.add(new Operation(-1, null, xCoord, dest
						.charAt(xCoord)));
			}
		}

		return operations;
	}

	/**
	 * 
	 * @param num1
	 *            first number to compare
	 * @param num2
	 *            second number to compare
	 * @param num3
	 *            third number to compare
	 * @return 0 if num1 is the smallest, 1 if num2 is the smallest, 2 is num3
	 *         is the smallest
	 */
	public static int min(int num1, int num2, int num3) {
		return num1 < num2 ? (num1 < num3 ? 0 : 2) : (num2 < num3 ? 1 : 2);
	}

	public static int[][] buildArray(String src, String dest) {
		int[][] arr = new int[dest.length() + 1][src.length() + 1];

		// First row is filled in increasing order
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = i;
		}

		// First column is filled in increasing order
		for (int i = 0; i < arr[0].length; i++) {
			arr[0][i] = i;
		}

		// Build the array one row at a time
		for (int d = 1; d < arr.length; d++) {
			for (int s = 1; s < arr[d].length; s++) {
				// If the two characters are the same, then no edits are needed
				// so the current value is taken diagonally from the top right
				if (src.charAt(s - 1) == dest.charAt(d - 1)) {
					arr[d][s] = arr[d - 1][s - 1];
				} else { // If they are not the same, then get the smallest
							// value from left, top left and the one above plus
							// one (the edit needed)
					arr[d][s] = Integer.min(arr[d - 1][s],
							Integer.min(arr[d][s - 1], arr[d - 1][s - 1])) + 1;
				}
			}
		}

		return arr;
	}

	/**
	 * This class represents the 3 operations for editing: adding, replacing and
	 * removing. If the operation is adding, then locSrc will be -1 and src will
	 * be null and other fields will be initialized. If the operation is
	 * replacing, then all the fields will be initialized. If the operation is
	 * removing then locDest will be -1 and dest will be null and all the other
	 * fields will be initialized
	 */
	public static class Operation {
		private int locSrc;
		private Character src;
		private int locDest;
		private Character dest;

		Operation(int ls, Character s, int ds, Character d) {
			src = s;
			dest = d;
			locSrc = ls;
			locDest = ds;
		}

		@Override
		public String toString() {
			return "Location: " + locSrc + " Character: " + src
					+ " Destination: " + locDest + " Character: " + dest;
		}

		public Character getSrc() {
			return src;
		}

		public Character getDest() {
			return dest;
		}

		public int getLocSrc() {
			return locSrc;
		}

		public int getLocDest() {
			return locDest;
		}
		
		@Override
		public boolean equals(Object o) {
			if (o instanceof Operation) {
				Operation e = (Operation) o;
				
				return locSrc == e.locSrc && src.equals(e.src) && locDest == e.locDest && dest.equals(e.dest);
			} else {
				return false;
			}
		}
	}
}