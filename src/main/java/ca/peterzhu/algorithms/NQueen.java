package ca.peterzhu.algorithms;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
	public static List<Coord> compute(int size) {
		List<Coord> positions = new ArrayList<>();

		// If b is false then there are no results
		boolean b = compute(0, size, positions);

		return positions;
	}

	private static boolean compute(int depth, int size, List<Coord> positions) {
		// Loops through all the column locations it can be in
		largeLoop: for (int i = 0; i < size; i++) {
			// Checks all existing queens for possible attacks.
			for (Coord c : positions) {
				// If they are on the same column, row or diagonal then move to
				// the next spot
				if (c.xCoord == depth || c.yCoord == i
						|| i - depth == c.yCoord - c.xCoord
						|| i + depth == c.yCoord + c.xCoord) {
					continue largeLoop;
				}
			}

			// If there are no possible attacks, then add this queen.
			positions.add(new Coord(depth, i));

			// If the end of the board is reached, then the calculations are
			// complete.
			if (depth == size - 1) {
				return true;
			}

			// Calculate for the next row
			boolean result = compute(depth + 1, size, positions);

			// If this current position did not work, then remove this piece and
			// try the next position.
			if (!result) {
				positions.remove(new Coord(depth, i));
				continue;
			} else {
				return true;
			}
		}

		return false;
	}

	public static class Coord {
		private int xCoord, yCoord;

		Coord(int x, int y) {
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
