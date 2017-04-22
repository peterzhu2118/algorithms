package ca.peterzhu.algorithms;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class DisjointSetTest {
	
	@Test
	public void testDisjointSet() {
		DisjointSet d = new DisjointSet();
		d.addVal(1);
		d.addVal(2);
		d.addVal(3);
		d.addVal(4);
		d.addVal(5);
		d.addVal(6);
		d.addVal(7);
		
		d.union(1, 2);
        d.union(2, 3);
        d.union(4, 5);
        d.union(6, 7);
        d.union(5, 6);
        d.union(3, 7);
        
        List<DisjointSetNode> nodes = d.getVals();
        
        Assert.assertEquals(1, nodes.get(0).value);
        Assert.assertEquals(4, nodes.get(3).value);
        Assert.assertEquals(1, nodes.get(0).rank);
	}

}
