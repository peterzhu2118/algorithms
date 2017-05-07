package ca.peterzhu.algorithms;

import org.junit.Assert;
import org.junit.Test;

public class LongestIncreasingSubsequencenlognTest {

	@Test
	public void testIncreasingSubsequence() {
		Assert.assertArrayEquals(
				new int[] { -1, 2, 3, 7, 9, 10 },
				LongestIncreasingSubsequencenlogn.compute(new int[] { 3, 4, -1,
						5, 8, 2, 3, 12, 7, 9, 10 }));
		Assert.assertArrayEquals(
				new int[] { 1, 9, 10 },
				LongestIncreasingSubsequencenlogn.compute(new int[] { 1, 9, 10,
						2 }));
		Assert.assertArrayEquals(
				new int[] { -1, 0, 2, 3 },
				LongestIncreasingSubsequencenlogn.compute(new int[] { 3, 4, -1,
						0, 6, 2, 3 }));
		Assert.assertArrayEquals(
				new int[] { 1, 4, 6, 9 },
				LongestIncreasingSubsequencenlogn.compute(new int[] { 1, 5, 4,
						6, 9 }));
	}

}
