package ca.peterzhu.algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Finds all the cycles in a directed graph. Edge weights may be negative but no
 * negative weight cycles may exist.
 * 
 * @author Peter
 * 
 */
public class JohnsonsAllCycle {
	private StronglyConnectedComponents scc;
	private boolean[][] edges;
	private Set<Integer> vertices;

	public JohnsonsAllCycle(int size) {
		scc = new StronglyConnectedComponents(size);
		edges = new boolean[size][size];
		vertices = new HashSet<>();
	}

	public void addEdge(int src, int dest) {
		scc.addEdge(src, dest);

		edges[src][dest] = true;
		vertices.add(src);
		vertices.add(dest);
	}

	/**
	 * 
	 * @return List containing a list of all the cycles
	 */
	public List<List<Integer>> compute() {
		List<Set<Integer>> s = scc.compute();

		List<List<Integer>> result = new ArrayList<>();

		while (true) {
			int currNode = 0;
			int currPos = -1;

			// If there is a strongly connected component of size larger than 1
			// (has more than one vertex), then use it. Else, the calculation is
			// complete and break.
			for (int i = 0; i < s.size(); i++) {
				if (s.get(i).size() > 1) {
					currNode = (Integer) s.get(i).toArray()[0];
					currPos = i;
				}
			}

			if (currPos == -1) {
				break;
			}

			// Add all the cycles in the current graph to the list of cycles.
			result.addAll(compute(currNode, currNode, s.get(currPos),
					new ArrayDeque<Integer>(), new HashSet<Integer>(),
					new HashMap<Integer, Integer>()));

			// Remove this vertex from the graph.
			removeEdges(currNode);

			// Recalculate the strongly connected components because this vertex
			// is removed.
			scc = new StronglyConnectedComponents(edges.length);
			scc.addAll(edges, vertices);

			s = scc.compute();
		}

		// Reverse every list for the correct order
		for (List<Integer> i : result) {
			Collections.reverse(i);
		}

		return result;
	}

	private void removeEdges(int node) {
		vertices.remove(node);

		for (int i = 0; i < edges.length; i++) {
			edges[node][i] = false;
			edges[i][node] = false;
		}
	}

	private List<List<Integer>> compute(int node, int startVertex,
			Set<Integer> vertices, Deque<Integer> stack, Set<Integer> blockSet,
			Map<Integer, Integer> blockMap) {
		List<List<Integer>> result = new ArrayList<>();

		// If the source vertex is reached (a cycle is found), then add the
		// elements in the stack (the cycle) to the list and return.
		if (stack.size() > 1 && node == startVertex) {
			result.add(new ArrayList<Integer>(stack));
			return result;
		}

		// If this node has not been accessed, then add it to the blocked set
		// (it is accessed) and push it into the stack.
		if (!blockSet.contains(node)) {
			blockSet.add(node);
			stack.push(node);
			boolean foundCycle = false;

			// Recursively access all children of this vertex.
			for (int i = 0; i < edges[node].length; i++) {
				if (edges[node][i]) {
					List<List<Integer>> r = compute(i, startVertex, vertices,
							stack, blockSet, blockMap);

					if (r.size() > 0) {
						foundCycle = true;
						result.addAll(r);
					}
				}
			}

			// If no cycle was found in the children then add this vertex and
			// the parent vertex into the block map. If a cycle was found then
			// unblock this vertex, and the the value for this vertex and the
			// value for that vertex, etc. until the end is reached in the block
			// map.
			stack.pop();
			if (!foundCycle) {
				blockMap.put(node, stack.peek());
			} else {
				blockSet.remove(node);

				Integer toRemove = node;

				while (true) {
					toRemove = blockMap.remove(toRemove);

					if (toRemove == null) {
						break;
					} else {
						blockSet.remove(toRemove);
					}
				}
			}
		} else {
			blockMap.put(node, stack.peek());
		}

		return result;
	}
}
