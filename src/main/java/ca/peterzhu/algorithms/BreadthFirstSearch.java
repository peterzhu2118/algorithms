package ca.peterzhu.algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * BFS for a undirected graph (remove a section of code below for directed).
 * 
 * @author Peter
 * 
 */
public class BreadthFirstSearch {
	private Map<Integer, List<Integer>> edges;
	private Set<Integer> vertices;

	public BreadthFirstSearch() {
		edges = new HashMap<>();
		vertices = new HashSet<>();
	}

	public void addEdge(int src, int dest) {
		List<Integer> s = edges.get(src);
		if (s == null) {
			s = new ArrayList<>();
			s.add(dest);
			edges.put(src, s);
		} else {
			s.add(dest);
		}

		// Remove this for a directed graph
		List<Integer> d = edges.get(dest);
		if (d == null) {
			d = new ArrayList<>();
			d.add(src);
			edges.put(dest, d);
		} else {
			d.add(src);
		}

		vertices.add(src);
		vertices.add(dest);
	}

	/**
	 * 
	 * @param start
	 *            the node to start searching from
	 * @param search
	 *            the node to search for
	 * @return if the node exists or not
	 */
	public boolean search(int start, int search) {
		Deque<Integer> queue = new ArrayDeque<>();
		Set<Integer> visited = new HashSet<>();
		int currNode = start;

		visited.add(currNode);

		mainLoop: while (true) {
			if (currNode == search) {
				return true;
			}

			List<Integer> childNodes = edges.get(currNode);

			for (int i : childNodes) {
				// If the current child node has not been visited, add it to the
				// queue and visited list
				if (!visited.contains(i)) {
					// If the current child node is the one we are looking for
					// return it
					if (i == search) {
						return true;
					} else {
						visited.add(i);
						queue.add(i);
					}
				}
			}
			// As long as there are more elements in the queue
			if (queue.size() > 0) {
				currNode = queue.remove();
				continue mainLoop;
			} else {
				return false;
			}
		}
	}
}
