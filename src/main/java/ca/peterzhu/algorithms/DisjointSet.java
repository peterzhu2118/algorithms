package ca.peterzhu.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Forms sets using union. Runs compression algorithm to compress the amount of
 * levels of the graph.
 * 
 * @author Peter Zhu
 * 
 */
public class DisjointSet {
	// List of nodes
	private List<DisjointSetNode> nodes;

	public DisjointSet() {
		nodes = new ArrayList<>();
	}

	public DisjointSet(ArrayList<Integer> val) {
		this();
		for (int i : val) {
			nodes.add(new DisjointSetNode(i));
		}
	}

	public void addVal(int i) {
		DisjointSetNode n = new DisjointSetNode(i);
		// Guarantees no duplicate nodes
		if (!nodes.contains(n))
			nodes.add(n);
	}

	public List<DisjointSetNode> getVals() {
		completeCompress();
		return nodes;
	}

	/**
	 * Forms a larger set by combining two sets.
	 * 
	 * @param val1
	 *            Value of the set to combine
	 * @param val2
	 *            Value of the set to combine
	 * @return true if successfully combined, false otherwise
	 */
	public boolean union(int val1, int val2) {
		// Gets the root of the two nodes to union
		DisjointSetNode n1 = getRoot(search(val1));
		DisjointSetNode n2 = getRoot(search(val2));

		// If the two nodes are already in the same set then no action is needed
		if (n1 == n2) {
			return false;
		}

		// Adds the smaller value to the larger value. If they are the same then
		// do it randomly but increase the rank of the root.
		if (n1.rank > n2.rank) {
			n2.parent = n1;
		} else if (n1.rank < n2.rank) {
			n1.parent = n2;
		} else {
			n2.parent = n1;
			n1.rank++;
		}

		return true;
	}

	/**
	 * Returns the root of the child node. Compresses the set while doing so.
	 * 
	 * @param child
	 *            the child node
	 * @return the root of the node
	 */
	private DisjointSetNode getRoot(DisjointSetNode child) {
		// If the current node is the root node then return it
		if (child == child.parent) {
			return child;
		}

		// Else set the parent to the root by recursively calling this method
		// until the root is reached
		child.parent = getRoot(child.parent);
		return child.parent;

	}

	/**
	 * Searches for the node with the value passed in.
	 * @param val value of node to be searched for
	 * @return the node if it exists, null if it does not
	 */
	private DisjointSetNode search(int val) {
		int pos = nodes.indexOf(new DisjointSetNode(val));

		return pos == -1 ? null : nodes.get(pos);
	}

	/**
	 * Compresses the whole set. 
	 */
	private void completeCompress() {
		for (DisjointSetNode n : nodes) {
			getRoot(n);
		}
	}

	/**
	 * Tests if there is a single root for the whole set (i.e. all nodes point to the same parent node). 
	 * 
	 * @return true if there is a single root, false otherwise
	 */
	public boolean singleRoot() {
		// Compresses the set first
		completeCompress();

		if (nodes.size() > 0) {
			// Return true if all the parents are the same			
			int root = nodes.get(0).parent.value;
			
			for (DisjointSetNode d : nodes) {
				if (d.parent.value != root) {
					return false;
				}
			}
			return true;
		} else {
			throw new IllegalStateException();
		}
	}
}