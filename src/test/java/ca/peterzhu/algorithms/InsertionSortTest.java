package ca.peterzhu.algorithms;

import org.junit.Assert;
import org.junit.Test;

public class InsertionSortTest {
	
	@Test
	public void testMinimumPath() {
		int[] arr = new int[] { -5, 5, -8, 7, 9, 2, 4, -9, -4, 0 };

		InsertionSort.sort(arr);
		
		Assert.assertArrayEquals(new int[]{-9, -8, -5, -4, 0, 2, 4, 5, 7, 9}, arr);
	}

}
