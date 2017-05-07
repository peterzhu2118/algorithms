package ca.peterzhu.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class ArticulationPointTest {
	@Test
	public void testArticulation1() {
		ArticulationPoint test1 = new ArticulationPoint();
		test1.addEdge(1, 2);
        test1.addEdge(2, 3);
        test1.addEdge(1, 3);
        test1.addEdge(1, 4);
        test1.addEdge(4, 5);
        test1.addEdge(5, 6);
        test1.addEdge(6, 7);
        test1.addEdge(7, 5);
        test1.addEdge(6, 8);
        
        Set<Integer> result1 = test1.compute();
        Assert.assertEquals(new HashSet<Integer>(Arrays.asList(new Integer[] {1, 4, 5, 6})), result1);        
	}
	
	@Test
	public void testArticulation2() {
		ArticulationPoint test1 = new ArticulationPoint();
		test1.addEdge(0, 1);
        test1.addEdge(0, 2);
        test1.addEdge(0, 3);
        test1.addEdge(0, 4);
        test1.addEdge(4, 2);
        test1.addEdge(3, 5);
        test1.addEdge(4, 6);
        test1.addEdge(6, 3);
        test1.addEdge(6, 7);
        test1.addEdge(6, 8);
        test1.addEdge(7, 9);
        test1.addEdge(9, 10);
        test1.addEdge(8, 10);
        
        Set<Integer> result1 = test1.compute();
        Assert.assertEquals(new HashSet<Integer>(Arrays.asList(new Integer[] {0, 3, 6})), result1);
	}
}
