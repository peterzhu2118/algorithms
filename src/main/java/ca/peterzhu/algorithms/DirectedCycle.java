package ca.peterzhu.algorithms;

import java.util.*;

/**
 * Detects cycles in a directed graph. Note that it will either return null (no
 * cycles) or a set with one of the cycles. Use Johnson's all cycle for all the
 * cycles.
 * 
 * @author Peter
 * 
 */
public class DirectedCycle {
	private Map<Integer, List<Integer>> edges;
	private Set<Integer> vertices;

	public DirectedCycle() {
		edges = new HashMap<>();
		vertices = new HashSet<>();
	}

	public void addEdge(int src, int dest) {
		List<Integer> l = edges.get(src);
		if (l == null) {
			l = new ArrayList<>();
			l.add(dest);
			edges.put(src, l);
		} else {
			l.add(dest);
		}
		vertices.add(src);
		vertices.add(dest);
	}

	public Set<Integer> isCycle() {
		Set<Integer> whiteSet = new HashSet<>(vertices);
		Set<Integer> graySet = new HashSet<>();
		Set<Integer> blackSet = new HashSet<>();
		Map<Integer, Integer> parent = new HashMap<>();

		Deque<Integer> vertexAccessed = new ArrayDeque<>();
		vertexAccessed.push((Integer) whiteSet.toArray()[0]);

		parent.put(vertexAccessed.peek(), null);

		whiteSet.remove(vertexAccessed.peek());
		graySet.add(vertexAccessed.peek());

		mainLoop: while (true) {
			// List of connected vertices for this vertex
			List<Integer> e = edges.get(vertexAccessed.peek());
			if (e != null) {
				for (int dest : e) {
					// If this point has already been visited
					if (blackSet.contains(dest)) {
						continue;
					} else if (graySet.contains(dest)) { // If the gray set
															// contains
															// the destination
															// (i.e.
															// there is a cycle)
						return graySet;
					} else { // If the vertex needs to be visited
						parent.put(dest, vertexAccessed.peek());
						vertexAccessed.push(dest);
						whiteSet.remove(vertexAccessed.peek());
						graySet.add(vertexAccessed.peek());
						continue mainLoop;
					}
				}
			}

			// All edges accessed so this vertex is added to the black set
			if (graySet.size() > 0) {
				graySet.remove(vertexAccessed.peek());
				blackSet.add(vertexAccessed.peek());
				vertexAccessed.pop();
			} else if (whiteSet.size() == 0) { // If the white set is empty then
												// there is no cycle
				return null;
			} else { // A random new point needs to be added
				vertexAccessed.push((Integer) whiteSet.toArray()[0]);

				parent.put(vertexAccessed.peek(), null);

				whiteSet.remove(vertexAccessed.peek());
				graySet.add(vertexAccessed.peek());
			}
		}
	}

}
