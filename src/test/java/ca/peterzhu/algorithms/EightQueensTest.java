package ca.peterzhu.algorithms;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class EightQueensTest {

	@Test
	public void testEightQueens() {
		List<EightQueens.Coord> coord = new ArrayList<>();
		coord.add(new EightQueens.Coord(0, 0));
		List<int[]> result = EightQueens.compute(coord, 0);

		Assert.assertArrayEquals(new Integer[][] { { 0, 4, 7, 5, 2, 6, 1, 3 },
				{ 0, 5, 7, 2, 6, 3, 1, 4 }, { 0, 6, 3, 5, 7, 1, 4, 2 },
				{ 0, 6, 4, 7, 1, 3, 5, 2 } }, result.toArray());
		
		List<int[]> result1 = EightQueens.compute(new ArrayList<EightQueens.Coord>(), 0);
		
		Assert.assertEquals(92, result1.size());
	}

}
