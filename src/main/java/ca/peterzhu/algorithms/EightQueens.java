package ca.peterzhu.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list of queens already on the board, find all the other places queens
 * can be placed so they cannot attack each other.
 * 
 * @author Peter
 * 
 */
public class EightQueens {
	// Change this variable to change the board size
	private static final int BOARD_SIZE = 8;

	/**
	 * Computes recursively. Takes O(n!) to compute.
	 * 
	 * @param pieces
	 *            List of pieces. Put empty list for all possibilities. Place
	 *            pieces at the beginning if there are pieces that cannot be
	 *            moved
	 * @param row
	 *            The current row. Start at 0
	 * @return the List of int array that contains the column number for a
	 *         specific row
	 */
	public static List<int[]> compute(List<Coord> pieces, int row) {
		List<int[]> result = new ArrayList<>();

		// Loops to check every column
		largeLoop: for (int i = 0; i < BOARD_SIZE; i++) {
			// Loops through every current piece
			for (int x = 0; x < pieces.size(); x++) {
				Coord c = pieces.get(x);

				// If the piece for this row exists (was placed when teh method
				// was called), then compute for this column only (break
				// afterwards)
				if (c.yCoord == row) {
					// If the end of the board has been reached, then return
					// this value
					if (row == BOARD_SIZE - 1) {
						int[] r = new int[BOARD_SIZE];
						r[row] = i;
						result.add(r);
						return result;
					}

					// Recursively compute for the next row
					List<int[]> r = compute(pieces, row + 1);

					// Set every element for this row to this column
					for (int[] a : r) {
						a[row] = i;
					}

					// If there are results, add it to the list of results
					if (r != null && r.size() > 0) {
						result.addAll(r);
					}

					break largeLoop;
				}

				// If there is a possible attack (queen on same column or
				// diagonal) then go to the next column)
				if (c.xCoord == i || i - row == c.xCoord - c.yCoord
						|| i + row == c.yCoord + c.xCoord) {
					continue largeLoop;
				}
			}

			// If the end of the board has been reached, then return
			// this value
			if (row == BOARD_SIZE - 1) {
				int[] r = new int[BOARD_SIZE];
				r[row] = i;
				result.add(r);
				return result;
			}

			// Add this position to the list of pieces
			pieces.add(new Coord(i, row));

			// Recursively compute for the next row
			List<int[]> r = compute(pieces, row + 1);

			// Set every element for this row to this column
			for (int[] a : r) {
				a[row] = i;
			}

			// If there are results, add it to the list of results
			if (r != null && r.size() > 0) {
				result.addAll(r);
			}

			// Remove this piece and continue to the column
			pieces.remove(pieces.size() - 1);
		}

		return result;
	}

	public static class Coord {
		private int xCoord, yCoord;

		public Coord(int x, int y) {
			xCoord = x;
			yCoord = y;
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Coord) {
				Coord c = (Coord) o;

				return c.xCoord == xCoord && c.yCoord == yCoord;
			} else
				return false;
		}

		@Override
		public String toString() {
			return "X: " + xCoord + " Y: " + yCoord;
		}

		public int getxCoord() {
			return xCoord;
		}

		public int getyCoord() {
			return yCoord;
		}
	}

}
