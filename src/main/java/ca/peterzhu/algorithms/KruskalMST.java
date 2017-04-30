package ca.peterzhu.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Forms the minimum spanning tree. Sorts all the edges in ascending order and
 * then attempts to add each edge to the disjoint set (using union). If the
 * adding operation succeeds (i.e. the two vertices are not on the same set)
 * then edge is part of the MST, otherwise, it is not.
 * 
 * @author Peter Zhu
 * 
 */
public class KruskalMST {
	private List<WeightedUndirectedGraphEdge> edges;
	private DisjointSet vertices;

	public KruskalMST() {
		edges = new ArrayList<>();
		vertices = new DisjointSet();
	}

	/**
	 * Adds an edge to the list of edges and the two vertices to the disjoint
	 * set.
	 * 
	 * @param src
	 *            first vertex
	 * @param dest
	 *            second vertex
	 * @param weight
	 *            weight of the vertex
	 */
	public void addEdge(int src, int dest, int weight) {
		edges.add(new WeightedUndirectedGraphEdge(src, dest, weight));
		vertices.addVal(src);
		vertices.addVal(dest);
	}

	/**
	 * Calculates the MST.
	 * 
	 * @return the vertices representing the MST
	 */
	public List<WeightedUndirectedGraphEdge> MST() {
		// Sorts the list of edges
		sort();

		List<WeightedUndirectedGraphEdge> mst = new ArrayList<>();

		for (WeightedUndirectedGraphEdge w : edges) {
			// If the disjoint set addition was successful then the edge is part
			// of the MST
			if (vertices.union(w.src, w.dest))
				mst.add(w);

			// If there is only a single root in the disjoint set then the MST
			// is complete
			if (vertices.singleRoot())
				break;
		}

		return mst;
	}

	private void sort() {
		Collections.sort(edges);
	}
}
