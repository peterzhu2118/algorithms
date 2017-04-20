package ca.peterzhu.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Implementation of Dijkstra's algorithm. Finds the shortest path to all nodes
 * from a starting point. Cannot have negative edge weights or node numbers. An
 * instance of this class can be reused as long as 'compute' method is called
 * every time.
 * 
 * @author Peter Zhu
 * 
 */
public class DijkstrasShortestPath {
	private Map<Integer, List<Edge>> edges;
	private Set<Integer> nodes;

	private Map<Integer, Integer> previous;
	private Map<Integer, Integer> distance;

	public DijkstrasShortestPath() {
		edges = new HashMap<>();
		nodes = new HashSet<>();
	}

	/**
	 * 
	 * @param src
	 *            positive starting node value
	 * @param dest
	 *            positive ending node value
	 * @param weight
	 *            weight of the edge
	 */
	public void addEdge(int src, int dest, int weight) {
		nodes.add(src);
		nodes.add(dest);

		Edge edge1 = new Edge(dest, weight);
		List<Edge> list1 = edges.get(src);
		if (list1 == null) {
			list1 = new ArrayList<>();
			list1.add(edge1);
			edges.put(src, list1);
		} else {
			list1.add(edge1);
		}

		// Uncomment for undirected graph
		// Edge edge2 = new Edge(src, weight);
		// List<Edge> list2 = edges.get(dest);
		// if (list2 == null) {
		// list2 = new ArrayList<>();
		// list2.add(edge2);
		// edges.put(dest, list2);
		// } else {
		// list2.add(edge2);
		// }
	}

	/**
	 * Call this method to compute. Will need to be called if the graph is
	 * changed (i.e. 'addEdge' method is called).
	 * 
	 * @param startingNode
	 *            the node to start with
	 */
	public void compute(int startingNode) {
		previous = new HashMap<>();
		distance = new HashMap<>();

		ArrayList<Temp> tempDistance = new ArrayList<>();

		// Initialize the previous nodes to -1 and the distance to each node to
		// be infinity
		for (int i : nodes) {
			previous.put(i, -1);
			distance.put(i, Integer.MAX_VALUE);

			if (i != startingNode)
				tempDistance.add(new Temp(i, Integer.MAX_VALUE));
		}

		distance.put(startingNode, 0);
		tempDistance.add(new Temp(startingNode, 0));

		// While there are still unvisited nodes
		while (tempDistance.size() > 0) {
			// Node with the least distance will be selected first
			Collections.sort(tempDistance);

			int currNode = tempDistance.get(tempDistance.size() - 1).node;

			// Visited this node so remove it
			tempDistance.remove(tempDistance.size() - 1);

			// Get all edges connected to this node
			List<Edge> currEdge = edges.get(currNode);
			for (Edge e : currEdge) {
				// The weight of the path if this edge is used
				int currPathWeight = distance.get(currNode) + e.weight;

				// If this new path is more optimal than the previous result,
				// replace the old result with this one
				if (currPathWeight < distance.get(e.dest)) {
					distance.replace(e.dest, currPathWeight);
					previous.put(e.dest, currNode);

					for (Temp t : tempDistance) {
						if (t.node == e.dest) {
							t.totalDistance = currPathWeight;
						}
					}
				}
			}

		}
	}

	/**
	 * 
	 * @param toNode
	 *            the destination node
	 * @return the distance from the start node to this node, maximum value if
	 *         there is no path
	 */
	public int distance(int toNode) {
		return distance.get(toNode);
	}

	/**
	 * 
	 * @param toNode
	 *            the destination node
	 * @return the path as a list starting with the destination (i.e. toNode)
	 *         and ending with the starting node
	 */
	public List<Integer> path(int toNode) {
		int currNode = toNode;

		List<Integer> path = new ArrayList<>();

		path.add(currNode);

		while (true) {
			int previousNode = previous.get(currNode);

			if (previousNode == -1) {
				break;
			}

			path.add(previousNode);
			currNode = previousNode;
		}

		return path;
	}

	private class Temp implements Comparable<Temp> {
		private int node;
		private int totalDistance;

		public Temp(int n, int t) {
			node = n;
			totalDistance = t;
		}

		@Override
		public int compareTo(Temp o) {
			return -((Integer) totalDistance).compareTo(o.totalDistance);
		}

		// public boolean equals(Object o) {
		// if (o instanceof Temp) {
		// Temp t = (Temp) o;
		//
		// return t.node == node;
		// } else if (o instanceof Integer) {
		// return ((Integer) o).equals(node);
		// }else {
		// return false;
		// }
		// }
		//

		public String toString() {
			return "Node: " + node + " Total Distance: " + totalDistance;
		}
	}

	private class Edge implements Comparable<Edge> {
		private int dest;
		private int weight;

		public Edge(int d, int w) {
			dest = d;
			weight = w;
		}

		@Override
		public int compareTo(Edge o) {
			return ((Integer) weight).compareTo(o.weight);
		}
	}
}
