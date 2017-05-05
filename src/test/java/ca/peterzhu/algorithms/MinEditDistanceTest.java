package ca.peterzhu.algorithms;

import org.junit.Assert;
import org.junit.Test;

public class MinEditDistanceTest {

	@Test
	public void testEditDistance() {
		Assert.assertArrayEquals(new MinEditDistance.Operation[] {
				new MinEditDistance.Operation(2, '3', 2, '1'),
				new MinEditDistance.Operation(0, '1', 0, '3') },
				MinEditDistance.compute("123", "321").toArray());
	}

}
