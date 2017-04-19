package ca.peterzhu.algorithms;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {
	@Test
	public void testSort() {
		int[] sort = new int[]{2,4,3,1,9,6,10,4,5};
		BubbleSort.sort(sort);
		
		Assert.assertArrayEquals(new int[]{1,2,3,4,4,5,6,9,10}, sort);
		
	}
}
