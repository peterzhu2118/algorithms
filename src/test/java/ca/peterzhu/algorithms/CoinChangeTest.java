package ca.peterzhu.algorithms;

import org.junit.Assert;
import org.junit.Test;

public class CoinChangeTest {
	
	@Test
	public void testCoinChange() {
		Assert.assertArrayEquals(new Integer[]{6, 3}, CoinChange.compute(9, new int[]{7,1,3,6}).toArray());
		Assert.assertArrayEquals(new Integer[]{7, 7}, CoinChange.compute(14, new int[]{7,1,3,6}).toArray());
		Assert.assertArrayEquals(new Integer[]{7}, CoinChange.compute(7, new int[]{7,1,3,6}).toArray());
		Assert.assertArrayEquals(new Integer[]{5, 1, 1, 1, 1}, CoinChange.compute(9, new int[]{1, 5, 10, 20}).toArray());
	}

}
