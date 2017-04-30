package ca.peterzhu.algorithms;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class KruskalMSTTest {

	@Test
	public void testMST() {
		KruskalMST k = new KruskalMST();

		k.addEdge(1, 2, 3);
		k.addEdge(2, 3, 1);
		k.addEdge(1, 4, 1);
		k.addEdge(2, 4, 3);
		k.addEdge(3, 4, 1);
		k.addEdge(3, 6, 4);
		k.addEdge(3, 5, 5);
		k.addEdge(4, 5, 6);
		k.addEdge(6, 5, 2);

		List<WeightedUndirectedGraphEdge> mst = k.MST();

		Assert.assertTrue(Arrays.asList(new WeightedUndirectedGraphEdge[] {
				new WeightedUndirectedGraphEdge(2, 3, 1),
				new WeightedUndirectedGraphEdge(1, 4, 1),
				new WeightedUndirectedGraphEdge(3, 4, 1),
				new WeightedUndirectedGraphEdge(6, 5, 2),
				new WeightedUndirectedGraphEdge(3, 6, 4) }).containsAll(mst));
	}

}
