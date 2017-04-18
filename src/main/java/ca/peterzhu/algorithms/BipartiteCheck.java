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
 * Checks if a graph is Bipartite or not. A bipartite graph means that every
 * vertices can be divided into two independent sets such that every edge
 * connects a vertex pair from each set.
 * 
 * In more simple terms, it means that using two colors, every vertex can be
 * colored such that its adjacent vertices have the other color.
 * 
 * Uses a variation of BFS.
 * 
 * @author Peter Zhu
 * 
 */
public class BipartiteCheck {
	private Map<Integer, List<Integer>> edges;
	private Set<Integer> vertices;

	public BipartiteCheck() {
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

	public boolean check() {
		Deque<Integer> queue = new ArrayDeque<>();
		int currNode = (int) vertices.toArray()[0];
		boolean currColor = true;

		// Stores the two colors of each vertex
		Map<Integer, Boolean> colors = new HashMap<>();

		colors.put(currNode, currColor);

		mainLoop: while (true) {
			// Child nodes of the current node
			List<Integer> childNodes = edges.get(currNode);

			// Loop over every child node
			for (int i : childNodes) {
				// If the color exists in the map
				if (colors.containsKey(i)) {
					// If the color in the map is opposite of the current color,
					// then thats ok. If they are the same then it is not a
					// bipartite graph
					if (colors.get(i).equals(!currColor)) {
						continue;
					} else {
						return false;
					}
				} else {
					// If the color does not exist in the colors map, then add
					// it to be the opposite of the current node.
					queue.add(i);
					colors.put(i, !currColor);
				}
			}

			// As long as there are more elements in the queue
			if (queue.size() > 0) {
				currNode = queue.remove();
				currColor = colors.get(currNode);
				continue mainLoop;
			} else {
				return true;
			}
		}
	}
}
