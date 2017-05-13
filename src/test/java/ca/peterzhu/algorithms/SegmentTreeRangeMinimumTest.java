package ca.peterzhu.algorithms;

import org.junit.Assert;
import org.junit.Test;

public class SegmentTreeRangeMinimumTest {

	@Test
	public void testMinumum() {
		SegmentTreeRangeMinimum s = new SegmentTreeRangeMinimum(new int[] { -1,
				2, -3, 10, -5, 2, 4, 11, 22, -10, 10 });
		
		Assert.assertEquals(-1, s.rangeMinQuery(0, 1));
		Assert.assertEquals(-3, s.rangeMinQuery(0, 2));
		Assert.assertEquals(-10, s.rangeMinQuery(0, 10));
		Assert.assertEquals(2, s.rangeMinQuery(5, 8));
	}

}
