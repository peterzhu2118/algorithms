package ca.peterzhu.algorithms;

import org.junit.Assert;
import org.junit.Test;

public class DijkstrasShortestPathTest {
	@Test
	public void testDistance() {
		DijkstrasShortestPath graph1 = new DijkstrasShortestPath();
		graph1.addEdge(1, 2, 4);
		graph1.addEdge(2, 1, 4);
		graph1.addEdge(1, 3, 2);
		graph1.addEdge(3, 1, 2);
		graph1.addEdge(2, 3, 1);
		graph1.addEdge(3, 2, 1);
		graph1.addEdge(3, 4, 8);
		graph1.addEdge(4, 3, 8);
		graph1.addEdge(2, 4, 5);
		graph1.addEdge(4, 2, 5);
		graph1.addEdge(4, 5, 2);
		graph1.addEdge(5, 4, 2);
		graph1.addEdge(4, 6, 6);
		graph1.addEdge(6, 4, 6);
		graph1.addEdge(6, 5, 3);
		graph1.addEdge(5, 6, 3);
		graph1.addEdge(3, 5, 10);
		graph1.addEdge(5, 3, 10);

		graph1.compute(1);

		Assert.assertEquals(13, graph1.distance(6));
		Assert.assertEquals(2, graph1.distance(3));
		Assert.assertEquals(3, graph1.distance(2));
		
		DijkstrasShortestPath graph2 = new DijkstrasShortestPath();
		graph2.addEdge(1, 2, 4);
		graph2.addEdge(2, 1, 4);
		graph2.addEdge(1, 3, 2);
		graph2.addEdge(3, 1, 2);
		graph2.addEdge(2, 3, 1);
		graph2.addEdge(3, 2, 1);
		graph2.addEdge(3, 4, 8);
		graph2.addEdge(4, 3, 8);
		graph2.addEdge(4, 5, 2);
		graph2.addEdge(5, 4, 2);
		graph2.addEdge(4, 6, 6);
		graph2.addEdge(6, 4, 6);
		graph2.addEdge(6, 5, 3);
		graph2.addEdge(5, 6, 3);
		graph2.addEdge(3, 5, 10);
		graph2.addEdge(5, 3, 10);

		graph2.compute(6);

		Assert.assertEquals(15, graph2.distance(1));
		Assert.assertEquals(13, graph2.distance(3));
		Assert.assertEquals(14, graph2.distance(2));

	}

	@Test
	public void testPath() {
		DijkstrasShortestPath graph1 = new DijkstrasShortestPath();
		graph1.addEdge(1, 2, 4);
		graph1.addEdge(2, 1, 4);
		graph1.addEdge(1, 3, 2);
		graph1.addEdge(3, 1, 2);
		graph1.addEdge(2, 3, 1);
		graph1.addEdge(3, 2, 1);
		graph1.addEdge(3, 4, 8);
		graph1.addEdge(4, 3, 8);
		graph1.addEdge(2, 4, 5);
		graph1.addEdge(4, 2, 5);
		graph1.addEdge(4, 5, 2);
		graph1.addEdge(5, 4, 2);
		graph1.addEdge(4, 6, 6);
		graph1.addEdge(6, 4, 6);
		graph1.addEdge(6, 5, 3);
		graph1.addEdge(5, 6, 3);
		graph1.addEdge(3, 5, 10);
		graph1.addEdge(5, 3, 10);

		graph1.compute(1);

		Assert.assertArrayEquals(new Integer[] { 6, 5, 4, 2, 3, 1 }, graph1
				.path(6).toArray());
		
		
	}
}
