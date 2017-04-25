package ca.peterzhu.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Finds shortest path in weighted graph. Can have negative weights but no
 * negative cycles.
 * 
 * @author Peter
 * 
 */
public class FloydWarshallAllPairShortestPath {
	private FloydWarshallAllPairShortestPath() {

	}

	/**
	 * Computes all pair shortest path. Row of matrix is from and column is to
	 * (i.e. d[1][0] is from 1 to 0). From itself to itself is always 0 (i.e.
	 * d[n][n] = 0).
	 * 
	 * @param d
	 * @return
	 */
	public static Result compute(int[][] d) {
		Result r = new Result();

		r.distance = d;
		r.path = new int[d.length][d.length];

		// Uncomment to fill the path array with max values. Can be used to
		// check if there is no path to a particular vertex
		// for (int[] arr : r.path) Arrays.fill(arr, Integer.MAX_VALUE);

		// Builds the path array with all the edges
		for (int i = 0; i < r.distance.length; i++) {
			for (int x = 0; x < r.distance[i].length; x++) {
				if (r.distance[i][x] != Integer.MAX_VALUE) {
					r.path[i][x] = i;
				}
			}
		}

		for (int k = 0; k < r.distance.length; k++) {
			for (int i = 0; i < r.distance.length; i++) {
				for (int j = 0; j < r.distance.length; j++) {
					// If there is a path between i -> k and k -> j and the
					// distance from i -> j is greater than the distance from i
					// -> k -> j, then a shorter path has been found. Replace
					// the old distance with the new distance and change the
					// path to k.
					if (r.distance[i][k] != Integer.MAX_VALUE
							&& r.distance[k][j] != Integer.MAX_VALUE
							&& r.distance[i][j] > r.distance[i][k]
									+ r.distance[k][j]) {
						r.distance[i][j] = r.distance[i][k] + r.distance[k][j];
						r.path[i][j] = r.path[k][j];
					}
				}
			}
		}

		// If there are negative on the diagonal for the distance array then
		// there is a negative weight cycle (it takes negative weight to get
		// from path a to path a)
		for (int i = 0; i < r.distance.length; i++) {
			if (r.distance[i][i] < 0)
				throw new RuntimeException("Negative Cycle");
		}

		return r;

	}

	public static class Result {
		private int[][] distance;
		private int[][] path;

		private Result() {

		}

		/**
		 * Returns the distance between two points.
		 * 
		 * @param src
		 *            the source
		 * @param dest
		 *            the destination
		 * @return the shortest distance between the two points
		 */
		public int getDistance(int src, int dest) {
			return distance[src][dest];
		}

		/**
		 * Returns a list of the path between the two points.
		 * 
		 * @param src
		 *            the source
		 * @param dest
		 *            the destination
		 * @return null if there is no path, the shortest path otherwise
		 */
		public List<Integer> getPath(int src, int dest) {
			int val = path[src][dest];

			List<Integer> p = new ArrayList<>();

			p.add(dest);

			while (true) {
				// If there is no path, return null
				if (val == Integer.MAX_VALUE)
					return null;

				p.add(val);

				// If the source has been reached then break
				if (val == src)
					break;

				val = path[src][val];
			}

			Collections.reverse(p);

			return p;
		}
	}
}
