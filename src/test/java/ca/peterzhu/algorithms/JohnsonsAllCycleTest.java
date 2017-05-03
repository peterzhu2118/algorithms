package ca.peterzhu.algorithms;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class JohnsonsAllCycleTest {

	@Test
	public void testCycle() {
		JohnsonsAllCycle j = new JohnsonsAllCycle(9);

		j.addEdge(7, 8);
		j.addEdge(8, 7);
		j.addEdge(0, 7);
		j.addEdge(0, 1);
		j.addEdge(1, 8);
		j.addEdge(1, 6);
		j.addEdge(2, 0);
		j.addEdge(2, 1);
		j.addEdge(1, 2);
		j.addEdge(4, 1);
		j.addEdge(3, 4);
		j.addEdge(5, 3);
		j.addEdge(2, 5);
		j.addEdge(2, 3);
		j.addEdge(0, 4);

		List<List<Integer>> solution = j.compute();

		Assert.assertArrayEquals(new Integer[] { 7, 8 }, solution.get(0)
				.toArray());
		Assert.assertArrayEquals(new Integer[] { 0, 1, 2 }, solution.get(1)
				.toArray());
		Assert.assertArrayEquals(new Integer[] { 0, 4, 1, 2 }, solution.get(2)
				.toArray());
		Assert.assertArrayEquals(new Integer[] { 1, 2 }, solution.get(3)
				.toArray());
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4 }, solution.get(4)
				.toArray());
		Assert.assertArrayEquals(new Integer[] { 1, 2, 5, 3, 4 },
				solution.get(5).toArray());
	}

}
