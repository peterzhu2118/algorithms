package ca.peterzhu.algorithms;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {
	@Test
	public void testSearch() {
		int[] arr = new int[]{-10, -5, -3, 0, 4, 6, 8, 10};
		
		Assert.assertEquals(1, BinarySearch.search(arr, -5));
		Assert.assertEquals(7, BinarySearch.search(arr, 10));
		Assert.assertEquals(-1, BinarySearch.search(arr, 100));
	}
}
