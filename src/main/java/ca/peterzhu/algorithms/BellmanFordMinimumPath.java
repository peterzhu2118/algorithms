package ca.peterzhu.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Bellman-Ford algorithm computes all the shortest path from a single source
 * vertex to all other vertices in a weighted graph (weights can be negative).
 * 
 * @author Peter
 * 
 */
public class BellmanFordMinimumPath {
	private List<WeightedDirectedGraphEdge> edges;
	private Map<Integer, TempStorage> distance;
	private int source;

	/**
	 * Used as temporary storage for the distance and the parent in the map.
	 * When parent is null then this is the parent.
	 */
	private class TempStorage {
		public int distance;
		public Integer parent;

		public TempStorage(int d, Integer p) {
			distance = d;
			parent = p;
		}

		@Override
		public String toString() {
			return "Distance: " + distance + " Parent: " + parent;
		}
	}

	public BellmanFordMinimumPath(int s) {
		source = s;
		distance = new HashMap<>();
		edges = new ArrayList<>();

		// Put the source as having a distance of 0 to the source (itself) and
		// null as the parent
		distance.put(source, new TempStorage(0, null));
	}

	/**
	 * Adds a new edge into the edges array. Adds the two vertices if they do
	 * not exist in the distance map.
	 * 
	 * @param src
	 *            source vertex
	 * @param dest
	 *            destination vertex
	 * @param weight
	 *            weight of the edge
	 */
	public void addEdge(int src, int dest, int weight) {
		edges.add(new WeightedDirectedGraphEdge(src, dest, weight));
		distance.putIfAbsent(src, new TempStorage(Integer.MAX_VALUE, null));
		distance.putIfAbsent(dest, new TempStorage(Integer.MAX_VALUE, null));
	}

	public void compute() {
		// Performs the inner loop (n - 1) times where n is the number of
		// vertices.
		for (int i = 0; i < distance.size() - 1; i++) {
			for (WeightedDirectedGraphEdge e : edges) {
				TempStorage s = distance.get(e.getSrc());
				TempStorage d = distance.get(e.getDest());
				// Performs the relaxation check. If the destination of the
				// current edge does not lead to the source and the source
				// is not MAX_VALUE (i.e. already has a path that leads to it)
				// and the distance to the destination is greater than the
				// distance it takes to get to the source plus the weight of the
				// current edge (i.e. we just found a shorter path)
				if (e.getDest() != source && s.distance < Integer.MAX_VALUE
						&& d.distance > s.distance + e.getWeight()) {
					// Change the destination distance to the distance to the
					// source plus the weight of the edge. Change the parent of
					// the destination to the source.
					d.distance = s.distance + e.getWeight();
					d.parent = e.getSrc();
				}
			}
		}

		// Performs the loop one more time, if there are any changes then there
		// is a negative cycle and the result can't be calculated so an
		// exception is thrown.
		for (WeightedDirectedGraphEdge e : edges) {
			TempStorage s = distance.get(e.getSrc());
			TempStorage d = distance.get(e.getDest());
			if (e.getDest() != source && s.distance < Integer.MAX_VALUE
					&& d.distance > s.distance + e.getWeight()) {
				throw new RuntimeException("Negative cycle");
			}
		}
	}

	/**
	 * Returns a list of the path taken to get from the source to the specified
	 * destination.
	 * 
	 * @param dest
	 *            the destination to reach
	 * @return the list of paths
	 */
	public List<Integer> getPath(int dest) {
		List<Integer> path = new ArrayList<>();

		while (true) {
			// Add the current vertex into the list as long as the parent of
			// this vertex is not null (i.e. source vertex is reached)
			path.add(dest);

			if (distance.get(dest).parent != null)
				dest = distance.get(dest).parent;
			else
				break;
		}

		Collections.reverse(path);

		return path;
	}
}
