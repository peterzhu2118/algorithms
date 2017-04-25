package ca.peterzhu.algorithms;

import org.junit.Assert;
import org.junit.Test;

public class FloydWarshallAllPairShortestPathTest {
	
	@Test
	public void testMinimumPath() {
		int[][] distance = new int[][] { { 0, 3, 6, 15 },
				{ Integer.MAX_VALUE, 0, -2, Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 2 },
				{ 1, Integer.MAX_VALUE, Integer.MAX_VALUE, 0 } };

		FloydWarshallAllPairShortestPath.Result result = FloydWarshallAllPairShortestPath
				.compute(distance);
		
		Assert.assertEquals(3, result.getDistance(0, 3));
		Assert.assertArrayEquals(new Integer[]{0,1,2,3}, result.getPath(0, 3).toArray());
	}

}
