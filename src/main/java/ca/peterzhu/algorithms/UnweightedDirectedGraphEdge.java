package ca.peterzhu.algorithms;

public class UnweightedDirectedGraphEdge {
	private int src;
	private int dest;

	public UnweightedDirectedGraphEdge(int s, int d) {
		src = s;
		dest = d;
	}

	@Override
	public String toString() {
		return "Source: " + src + " Dest: " + dest;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof UnweightedDirectedGraphEdge) {
			UnweightedDirectedGraphEdge u = (UnweightedDirectedGraphEdge) o;
			
			return u.src == src && u.dest == dest;
		} else {
			return false;
		}
	}

	public int getSrc() {
		return src;
	}

	public int getDest() {
		return dest;
	}
}
