package ca.peterzhu.algorithms;

import org.junit.Assert;
import org.junit.Test;


public class FenwickTreeTest {
	
	@Test
	public void testSum() {
		FenwickTree f = new FenwickTree(new int[]{1,2,-1,6,5,4,-3,3,7,2,2});
		
		f.update(10, 3);
		f.update(0, 3);
		f.update(1, 11);
		
		Assert.assertEquals(40, f.getSum(10));
	}

}
