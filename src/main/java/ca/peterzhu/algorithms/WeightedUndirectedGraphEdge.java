package ca.peterzhu.algorithms;

/**
 * A class that represents a edge in a graph that is weighted but undirected.
 * 
 * @author Peter Zhu
 * 
 */
public class WeightedUndirectedGraphEdge extends UnweightedUndirectedGraphEdge implements
		Comparable<WeightedUndirectedGraphEdge> {
	protected int weight;

	public WeightedUndirectedGraphEdge(int s, int d, int w) {
		super(s, d);
		weight = w;
	}

	@Override
	public int compareTo(WeightedUndirectedGraphEdge edge) {
		if (weight < edge.weight) {
			return -1;
		} else if (weight > edge.weight) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Vertex: " + src + ", " + dest + " Weight: " + weight;
	}
}
