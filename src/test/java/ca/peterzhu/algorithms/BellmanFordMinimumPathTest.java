package ca.peterzhu.algorithms;

import org.junit.Assert;
import ca.peterzhu.algorithms.BellmanFordMinimumPath;

import org.junit.Test;


public class BellmanFordMinimumPathTest {
	
	@Test
	public void test() {
		BellmanFordMinimumPath b = new BellmanFordMinimumPath(0);

		b.addEdge(3, 4, 2);
		b.addEdge(4, 3, 1);
		b.addEdge(2, 4, 4);
		b.addEdge(0, 2, 5);
		b.addEdge(1, 2, -3);
		b.addEdge(0, 3, 8);
		b.addEdge(0, 1, 4);

		b.compute();
		
		Assert.assertArrayEquals(new Integer[]{0, 1},  b.getPath(1).toArray());
		Assert.assertArrayEquals(new Integer[]{0, 1, 2}, b.getPath(2).toArray());
		Assert.assertArrayEquals(new Integer[]{0, 1, 2, 4, 3}, b.getPath(3).toArray());
		Assert.assertArrayEquals(new Integer[]{0, 1, 2, 4}, b.getPath(4).toArray());

//		BellmanFordMinimumPath bcycle = new BellmanFordMinimumPath(0);
//
//		bcycle.addEdge(0, 1, 1);
//		bcycle.addEdge(1, 2, 3);
//		bcycle.addEdge(2, 3, 2);
//		bcycle.addEdge(3, 1, -6);
//
//		bcycle.compute();
//
//		for (int i = 1; i < 5; i++) {
//			System.out.println(bcycle.getPath(i));
//		}
	}

}
