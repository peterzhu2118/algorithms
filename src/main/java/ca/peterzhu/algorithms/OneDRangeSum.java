package ca.peterzhu.algorithms;

/**
 * Class computes the sum between two ranges. Takes O(n) to build and takes O(1)
 * to retrieve. Takes O(n) space.
 */
public class OneDRangeSum {
	private int[] nums;
	private int[] sums;

	public OneDRangeSum(int[] n) {
		nums = n;

		sums = new int[nums.length];
		
		buildSums();
	}

	private void buildSums() {
		sums[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			sums[i] = sums[i - 1] + nums[i];
		}
	}

	/**
	 * Gets the sum between the start index (inclusive) and the end index (inclusive).
	 * 
	 * @param start start index
	 * @param end end index
	 * @return the sum between the two index
	 */
	public int getSum(int start, int end) {
		return start == 0 ? sums[end] : sums[end] - sums[start - 1];
	}
}
