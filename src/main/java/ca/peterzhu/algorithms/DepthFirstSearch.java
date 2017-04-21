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
 * DFS for a undirected graph (remove line below for directed graph). 
 * @author Peter Zhu
 *
 */
public class DepthFirstSearch {
	private Map<Integer, List<Integer>> edges;
	private Set<Integer> vertices;

	public DepthFirstSearch() {
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

	public boolean search(int start, int search) {
		Deque<Integer> stack = new ArrayDeque<>();
		Set<Integer> visited = new HashSet<>();
		int currNode = start;
		visited.add(currNode);
		stack.push(currNode);

		mainLoop: while (true) {
			// If the stack is empty (there are no more to visit)
			if (stack.size() == 0) {
				return false;
			}

			// If the current node is the search node, return true
			if (currNode == search) {
				// Return currNode if you want the object searched
				return true;
			}

			List<Integer> childNodes = edges.get(currNode);

			// Loop through all the child nodes of the current node
			for (int n : childNodes) {
				// If the current child node has not been visited then visit it
				if (!visited.contains(n)) {
					currNode = n;
					stack.push(n);
					visited.add(n);

					continue mainLoop;
				}
			}
			// After this for loops means that all child nodes has been visited
			// If this current node still has a parent then go to the parent
			if (stack.size() > 1) {
				stack.pop();
				int parent = stack.peek();

				currNode = parent;

				continue mainLoop;
			}
			
			// It reaches here it means that there there are no parent
			return false;
		}
	}
}
