package ca.peterzhu.algorithms;

import org.junit.Test;import org.junit.Assert;

public class BreadthFirstSearchTest {
	@Test
	public void testSearch() {
BreadthFirstSearch bfs = new BreadthFirstSearch();
		
		bfs.addEdge(1, 4);
		bfs.addEdge(4, 2);
		bfs.addEdge(2, 5);
		bfs.addEdge(1, 5);
		bfs.addEdge(4, 3);
		bfs.addEdge(3, 5);
		bfs.addEdge(7, 9);
		
		Assert.assertEquals(true, bfs.search(2, 1));
		Assert.assertEquals(false, bfs.search(7, 1));
		Assert.assertEquals(true, bfs.search(4, 1));
	}
}
