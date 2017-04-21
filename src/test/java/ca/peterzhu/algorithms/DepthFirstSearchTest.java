package ca.peterzhu.algorithms;

import org.junit.Test;import org.junit.Assert;

public class DepthFirstSearchTest {
	@Test
	public void testSearch() {
		DepthFirstSearch dfs = new DepthFirstSearch();
		
		dfs.addEdge(1, 4);
		dfs.addEdge(4, 2);
		dfs.addEdge(2, 5);
		dfs.addEdge(1, 5);
		dfs.addEdge(4, 3);
		dfs.addEdge(3, 5);
		dfs.addEdge(7, 9);
		
		Assert.assertEquals(true, dfs.search(2, 1));
		Assert.assertEquals(false, dfs.search(7, 1));
		Assert.assertEquals(true, dfs.search(4, 1));
	}
}
