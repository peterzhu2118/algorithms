package ca.peterzhu.algorithms;

import org.junit.Assert;
import org.junit.Test;

public class OneDRangeSumTest {
	
	@Test
	public void testSum() {
		int[] arr = new int[]{1, 2, 3, 4, 5, 6, -5, 6, 11, -20};
		
		OneDRangeSum o = new OneDRangeSum(arr);
		
		Assert.assertEquals(21, o.getSum(0,  5));
		Assert.assertEquals(-2, o.getSum(5,  9));
	}

}
