package ca.peterzhu.algorithms;

import java.util.Arrays;

/**
 * Tree represented by an array to find the smallest numbers within a range in
 * O(logn) time. Requires O(n) time to build the array. Use 2i + 1 to get left
 * node and 2i+2 to get right node. Use (i - 1)/2 to get parent.
 * 
 */
public class SegmentTreeRangeMinimum {
	private int[] nums;
	private int[] tree;

	public SegmentTreeRangeMinimum(int[] n) {
		nums = n;
		tree = new int[(int) Math.pow(log2(nums.length), 2) * 2 - 1];
		// Fill the tree array with MAX_VALUE so that if a node is empty, it
		// will not be mistaken as not empty (value 0).
		Arrays.fill(tree, Integer.MAX_VALUE);
		// Construct the tree
		constructTree(nums, tree, 0, nums.length - 1, 0);
	}

	/**
	 * @param val
	 * @return log2 of the value passed in rounded up
	 */
	private static int log2(int val) {
		return (int) Math.ceil(Math.log(val) / Math.log(2));
	}

	private static void constructTree(int[] input, int[] tree, int low,
			int high, int pos) {
		// If the end of the tree has been reached then assign this value to the
		// value in the input and return.
		if (low == high) {
			tree[pos] = input[low];
			return;
		}

		int mid = (low + high) / 2;

		// Recursively construct the tree for the left side
		constructTree(input, tree, low, mid, (2 * pos) + 1);
		// Recursively construct the tree for the right side
		constructTree(input, tree, mid + 1, high, (2 * pos) + 2);
		// Add the smaller of the two values to the tree
		tree[pos] = Integer.min(tree[2 * pos + 1], tree[2 * pos + 2]);
	}

	public int rangeMinQuery(int low, int high) {
		return rangeMinQuery(tree, low, high, 0, nums.length - 1, 0);
	}

	private static int rangeMinQuery(int[] tree, int qlow, int qhigh, int low,
			int high, int pos) {
		// If there is a total overlap (i.e. this current section completely
		// fits inside the searching boundaries) then return this value.
		if (qlow <= low && qhigh >= high)
			return tree[pos];

		// If there is no overlap, then return MAX_VALUE
		if (qlow > high || qhigh < low)
			return Integer.MAX_VALUE;

		int mid = (low + high) / 2;

		// Return the minimum of left and right child nodes
		return Integer.min(
				rangeMinQuery(tree, qlow, qhigh, low, mid, (2 * pos) + 1),
				rangeMinQuery(tree, qlow, qhigh, mid + 1, high, (2 * pos) + 2));
	}
}
