package ca.peterzhu.algorithms;

/**
 * A class that represents a node. When parent points to current object, this
 * object is the root.
 * 
 * @author Peter Zhu 
 */
public class DisjointSetNode {
	protected int rank = 0;
	protected int value = 0;
	protected DisjointSetNode parent = this;

	public DisjointSetNode(int v) {
		value = v;
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof DisjointSetNode ? ((DisjointSetNode) o).value == this.value
				: false;
	}

	@Override
	public String toString() {
		return "Value: " + value + ", rank: " + rank + ", parent value: "
				+ parent.value;
	}
}
