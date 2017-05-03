package ca.peterzhu.algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A graph is strongly connected if there is a path between all vertices. This
 * class returns all subgraphs that are a strongly connected graph.
 * 
 * @author Peter Zhu
 * 
 */
public class StronglyConnectedComponents {
	// Matrix to store the edges. If there is a path between src and dest then
	// [src][dest] is true.
	private boolean[][] edges;
	private Set<Integer> vertices;

	public StronglyConnectedComponents(int size) {
		edges = new boolean[size][size];
		vertices = new HashSet<>();
	}

	public void addEdge(int src, int dest) {
		edges[src][dest] = true;

		vertices.add(src);
		vertices.add(dest);
	}

	public void addAll(boolean[][] e, Set<Integer> v) {
		edges = e;
		vertices = v;
	}

	public List<Set<Integer>> compute() {
		// Set to store the visited nodes, a deque that acts as a stack to store
		// the order of finish and a stack of not visited vertices.
		Set<Integer> visited = new HashSet<>(vertices.size());
		Deque<Integer> finishTime = new ArrayDeque<>(vertices.size());
		Deque<Integer> notVisited = new ArrayDeque<>(vertices);

		// Used to remember the order of vertices (acts as a stack) so that
		// recursion is not needed.
		Deque<Integer> visitOrder = new ArrayDeque<>();

		visitOrder.push(notVisited.pop());

		// While there are more vertices to traverse
		largeLoop: while (visitOrder.size() > 0) {
			int currVertex = visitOrder.peek();
			if (!visited.contains(currVertex)) {
				visited.add(currVertex);
			}

			// Traverse through every edge for the current vertex, if the
			// destination vertex of that edge was never visited, then visit it.
			for (int i = 0; i < edges[currVertex].length; i++) {
				if (edges[currVertex][i]) {
					if (!visited.contains(i)) {
						visitOrder.push(i);
						continue largeLoop;
					}
				}
			}

			// Add the current vertex as visited and add current vertex as
			// finished
			visited.add(currVertex);
			notVisited.remove(currVertex);
			finishTime.push(currVertex);
			visitOrder.pop();

			if (visitOrder.size() == 0 && notVisited.size() > 0) {
				visitOrder.push(notVisited.pop());
			}

		}

		visited.clear();
		visitOrder.clear();

		List<Set<Integer>> result = new ArrayList<>();

		Set<Integer> currList = new HashSet<>();

		result.add(currList);
		visitOrder.push(finishTime.pop());

		// While there are more vertices to visit
		largeLoop: do {
			int currVertex = visitOrder.peek();
			currList.add(currVertex);

			// Visit every edge to this vertex (all edges are reversed in this
			// loop, if a -> b then now a <- b). If it was not visited then
			// visit this vertex.
			for (int i = 0; i < edges.length; i++) {
				if (edges[i][currVertex]) {
					if (!visited.contains(i)) {
						visitOrder.push(i);
						visited.add(i);
						continue largeLoop;
					}
				}
			}

			visited.add(currVertex);

			visitOrder.pop();

			if (visitOrder.size() == 0) {
				// Find the next vertex that has not been visited
				do {
					if (finishTime.size() == 0) {
						break largeLoop;
					}

					currVertex = finishTime.pop();
				} while (visited.contains(currVertex));
				visitOrder.push(currVertex);
				currList = new HashSet<>();
				currList.add(currVertex);
				visited.add(currVertex);
				result.add(currList);
			}
		} while (visitOrder.size() > 0);

		return result;
	}
}
