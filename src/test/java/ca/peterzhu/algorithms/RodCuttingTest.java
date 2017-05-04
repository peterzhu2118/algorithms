package ca.peterzhu.algorithms;

import org.junit.Assert;
import org.junit.Test;

public class RodCuttingTest {

	@Test
	public void testRodCutting() {
		Assert.assertArrayEquals(
				new Integer[] { 10, 2, 1 },
				RodCutting.compute(
						13,
						new int[][] { { 1, 1 }, { 2, 5 }, { 3, 2 }, { 4, 9 },
								{ 5, 10 }, { 6, 17 }, { 7, 17 }, { 8, 20 },
								{ 9, 24 }, { 10, 30 } }).toArray());
		
		Assert.assertArrayEquals(
				new Integer[] { 2, 2, 1 },
				RodCutting.compute(5,
						new int[][] { { 1, 2 }, { 2, 5 }, { 3, 7 }, { 4, 8 } })
						.toArray());
	}

}
