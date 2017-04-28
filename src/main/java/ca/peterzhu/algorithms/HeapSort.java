package ca.peterzhu.algorithms;

public class HeapSort {
	public static void sort(int[] nums) {
		// Heapify the array up to the (length / 2 - 1) point (don't need to
		// heapify the child nodes)
		for (int i = nums.length / 2 - 1; i >= 0; i--) {
			heapify(nums, nums.length, i);
		}

		// Swap the last element and the first (largest value and smallest
		// value) and re-heapify not including the last value (largest value)
		for (int i = nums.length - 1; i >= 0; i--) {
			int temp = nums[0];
			nums[0] = nums[i];
			nums[i] = temp;

			heapify(nums, i, 0);
		}

	}

	/**
	 * Heapify a node. Creates a max heap (largest value at top).
	 * 
	 * @param nums
	 *            The values of the nodes
	 * @param size
	 *            The size of the nums array to heapify (stop point)
	 * @param pos
	 *            the current position
	 */
	private static void heapify(int[] nums, int size, int pos) {
		int largest = pos;
		int left = getLeftChild(pos);
		int right = getRightChild(pos);

		// If the value of the left child is larger than the current max, set it
		// to the max
		if (left < size && nums[left] > nums[largest]) {
			largest = left;
		}

		// If the value of the right child is larger than the current max, set
		// it to the max
		if (right < size && nums[right] > nums[largest]) {
			largest = right;
		}

		// If the current value is not the max then swap current with the max
		// and recursively heapify the swapped node
		if (largest != pos) {
			int temp = nums[pos];
			nums[pos] = nums[largest];
			nums[largest] = temp;

			heapify(nums, size, largest);
		}
	}

	private static int getParent(int pos) {
		return (pos - 1) / 2;
	}

	private static int getLeftChild(int pos) {
		return 2 * pos + 1;
	}

	private static int getRightChild(int pos) {
		return 2 * pos + 2;
	}
}
