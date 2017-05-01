package ca.peterzhu.algorithms;

import org.junit.Assert;
import org.junit.Test;


public class DirectedCycleTest {
	
	@Test
	public void testCycle() {
		DirectedCycle cycle = new DirectedCycle();
		cycle.addEdge(1, 2);
		cycle.addEdge(2, 3);
		cycle.addEdge(3 , 1);
		cycle.addEdge(4, 1);
		cycle.addEdge(6, 4);
		cycle.addEdge(4, 5);
		cycle.addEdge(5, 6);
		Assert.assertArrayEquals(new Integer[]{1, 2, 3}, cycle.isCycle().toArray());
		
		DirectedCycle cycle2 = new DirectedCycle();
		cycle2.addEdge(1, 2);
		cycle2.addEdge(2, 3);
		cycle2.addEdge(3, 1);
		Assert.assertArrayEquals(new Integer[]{1, 2, 3}, cycle2.isCycle().toArray());
		
		DirectedCycle cycle3 = new DirectedCycle();
		cycle3.addEdge(1, 2);
		cycle3.addEdge(2, 3);
		cycle3.addEdge(3, 1);
		cycle3.addEdge(1, 4);
		cycle3.addEdge(4, 3);
		Assert.assertArrayEquals(new Integer[]{1, 2, 3}, cycle3.isCycle().toArray());
		
		DirectedCycle snakeCycle = new DirectedCycle();
		snakeCycle.addEdge(1, 1);
		Assert.assertArrayEquals(new Integer[]{1}, snakeCycle.isCycle().toArray());
		
		DirectedCycle notCycle = new DirectedCycle();
		notCycle.addEdge(1, 2);
		notCycle.addEdge(2, 3);
		notCycle.addEdge(3, 4);
		Assert.assertEquals(null, notCycle.isCycle());
	}

}
