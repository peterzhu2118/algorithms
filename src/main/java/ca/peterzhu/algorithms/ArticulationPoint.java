package ca.peterzhu.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArticulationPoint {
	private Map<Integer, List<Integer>> edges;
	private int time = 0;

	public ArticulationPoint() {
		edges = new HashMap<>();
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
	}
	
	public Set<Integer> compute(){
		Set<Integer> visited = new HashSet<>();
		Set<Integer> articulationPoints = new HashSet<>();
		int currVertex = (Integer) edges.keySet().toArray()[0];
		Map<Integer, Integer> visitedTime = new HashMap<>();
		Map<Integer, Integer> lowTime = new HashMap<>();
		Map<Integer, Integer> parent = new HashMap<>();
		
		compute(visited, articulationPoints, currVertex, visitedTime, lowTime, parent);
		
		return articulationPoints;
	}

	private void compute(Set<Integer> visited, Set<Integer> articulationPoints,
			int currVertex, Map<Integer, Integer> visitedTime,
			Map<Integer, Integer> lowTime, Map<Integer, Integer> parent) {
		visited.add(currVertex);
		visitedTime.put(currVertex, time);
		lowTime.put(currVertex, time);
		time++;
		int childCount = 0;
		boolean isArticulationPoint = false;

		for (int adj : edges.get(currVertex)) {
			// If the adjacent vertex is the parent of this vertex, then skip
			if (parent.get(currVertex) != null && parent.get(currVertex).equals(adj)) {
				continue;

				// If the adjacent vertex has not been visited
			} else if (!visited.contains(adj)) {
				parent.put(adj, currVertex);
				childCount++;

				// Recursively visit this adjacent vertex
				compute(visited, articulationPoints, adj, visitedTime,
						lowTime, parent);

				// If the visited time is lower or equal to the low time of the
				// adjacent vertex then it is an articulation point
				if (visitedTime.get(currVertex) <= lowTime.get(adj)) {
					isArticulationPoint = true;
				} else {
					// Else, set the current low time to be the smaller of the
					// current low time or the low time of the adjacent
					lowTime.replace(currVertex,
							Integer.min(lowTime.get(currVertex), lowTime.get(adj)));
				}
			} else { // If the adjacent node has already been visited check for
						// a better low time
				lowTime.replace(currVertex,
						Integer.min(lowTime.get(currVertex), visitedTime.get(adj)));
			}
		}

		// Checks for the two conditions:
		// 1) The current vertex is the root vertex and has 2 or more child
		// nodes
		// 2) THe current vertex is not the root vertex and is an articulation
		// point
		if ((parent.get(currVertex) == null && childCount >= 2)
				|| parent.get(currVertex) != null && isArticulationPoint) {
			articulationPoints.add(currVertex);
		}
	}
}
