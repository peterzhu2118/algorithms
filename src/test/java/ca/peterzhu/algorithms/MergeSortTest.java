package ca.peterzhu.algorithms;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {

	@Test
	public void testSort() {
		Assert.assertArrayEquals(
				new int[] { -15, -10, -10, 0, 1, 1, 1, 2, 2, 3, 3, 4, 5, 5, 6,
						6, 7, 7, 8, 10 },
				MergeSort.sort(new int[] { 5, 10, 7, 6, 3, 2, 1, 1, 2, 5, 6, 7,
						8, 3, 0, 1, 4, -10, -15, -10 }));
	}

}
