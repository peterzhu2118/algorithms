package ca.peterzhu.algorithms;

import java.util.Arrays;

/**
 * Used to find the sum between 0 and n in O(logn) time. Takes n space and takes
 * O(nlogn) time to build.
 */
public class FenwickTree {
	private int[] tree;
	private int[] values;

	public FenwickTree(int[] v) {
		values = v;
		tree = new int[values.length + 1];
		buildTree();
	}

	/**
	 * Returns the parent of the value. The following steps are done:
	 * 
	 * 1. Take the 2's compliment (- that value)
	 * 
	 * 2. And that with the original number
	 * 
	 * 3. Subtract from the original number
	 * 
	 * @param val
	 *            the value to find the parent
	 * @return the parent. 0 if the root has been reached.
	 */
	private static int getParent(int val) {
		return val - (val & -val);
	}

	/**
	 * Returns the next value (to find all the points needed to be updated). The following steps are done:
	 * 
	 * 1. Take the 2's compliment (- that value)
	 * 
	 * 2. And that with the original number
	 * 
	 * 3. Add to the original number
	 * 
	 * @param val
	 *            the value to find the next value
	 * @return the next value. Should stop if return value > tree size.
	 */
	private static int getNext(int val) {
		return val + (val & -val);
	}

	private void buildTree() {
		for (int i = 0; i < values.length; i++) {
			updatePrivate(i + 1, values[i]);
		}
	}

	public void update(int loc, int newVal) {
		int difference = newVal - values[loc];
		
		values[loc] = newVal;
		
		updatePrivate(loc + 1, difference);
	}

	private void updatePrivate(int loc, int difference) {
		tree[loc] += difference;

		int next = getNext(loc);

		if (next < tree.length) {
			updatePrivate(next, difference);
		}
	}

	public int getSum(int loc) {
		return privateGetSum(loc + 1);
	}

	public int privateGetSum(int loc) {
		if (loc == 0) {
			return 0;
		}

		return privateGetSum(getParent(loc)) + tree[loc];
	}
}
