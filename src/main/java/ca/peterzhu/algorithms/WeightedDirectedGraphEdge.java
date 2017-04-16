package ca.peterzhu.algorithms;

public class WeightedDirectedGraphEdge {
	private int src;
	private int dest;
	private int weight;

	public WeightedDirectedGraphEdge(int s, int d, int w) {
		src = s;
		dest = d;
		weight = w;
	}

	@Override
	public String toString() {
		return "Source: " + src + " Dest: " + dest + " Weight: " + weight;
	}

	public int getSrc() {
		return src;
	}

	public int getDest() {
		return dest;
	}

	public int getWeight() {
		return weight;
	}
}
