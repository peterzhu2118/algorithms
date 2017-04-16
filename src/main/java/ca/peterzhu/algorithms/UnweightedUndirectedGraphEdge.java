package ca.peterzhu.algorithms;

public class UnweightedUndirectedGraphEdge {
	int src;
	int dest;
	
	public UnweightedUndirectedGraphEdge(int s, int d) {
		src = s;
		dest = d;
	}
	
	@Override
	public String toString(){
		return "Vertex: " + src + ", " + dest;
	}
}
