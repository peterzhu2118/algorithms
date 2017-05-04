package ca.peterzhu.algorithms;

import org.junit.Assert;
import org.junit.Test;

public class NQueenTest {

	@Test
	public void testNQueen() {
		Assert.assertArrayEquals(new NQueen.Coord[] { new NQueen.Coord(0, 1),
				new NQueen.Coord(1, 3), new NQueen.Coord(2, 0),
				new NQueen.Coord(3, 2) }, NQueen.compute(4).toArray());
	}

}
