package ca.peterzhu.algorithms;

import org.junit.Test;
import org.junit.Assert;

public class BipartiteCheckTest {
	@Test
	public void testBipartiteCheck() {
		BipartiteCheck bpc1 = new BipartiteCheck();
		
		bpc1.addEdge(1, 2);
		bpc1.addEdge(2, 3);
		bpc1.addEdge(3, 4);
		bpc1.addEdge(4, 5);
		bpc1.addEdge(5, 1);
		
		Assert.assertEquals(false, bpc1.check());
		
		BipartiteCheck bpc2 = new BipartiteCheck();
		
		bpc2.addEdge(1, 2);
		bpc2.addEdge(2, 3);
		bpc2.addEdge(3, 4);
		bpc2.addEdge(4, 5);
		bpc2.addEdge(5, 6);
		bpc2.addEdge(6, 1);
		bpc2.addEdge(6, 2);
		
		Assert.assertEquals(false, bpc2.check());
		
		BipartiteCheck bpc3 = new BipartiteCheck();
		bpc3.addEdge(1, 2);
		bpc3.addEdge(8, 2);
		bpc3.addEdge(8, 6);
		bpc3.addEdge(1, 6);
		bpc3.addEdge(1, 3);
		bpc3.addEdge(4, 2);
		bpc3.addEdge(6, 5);
		bpc3.addEdge(8, 7);
		bpc3.addEdge(3, 4);
		bpc3.addEdge(4, 7);
		bpc3.addEdge(5, 7);
		
		Assert.assertEquals(true, bpc3.check());
	}
}
