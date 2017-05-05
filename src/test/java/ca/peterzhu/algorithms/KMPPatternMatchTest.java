package ca.peterzhu.algorithms;

import org.junit.Assert;
import org.junit.Test;


public class KMPPatternMatchTest {
	
	@Test
	public void testDoesNotExist() {
		Assert.assertEquals(-1, KMPPatternMatch.search("hello", "t"));
		Assert.assertEquals(-1, KMPPatternMatch.search("", "t"));
		Assert.assertEquals(-1, KMPPatternMatch.search("testing", "x"));
	}
	
	@Test
	public void testExistsOnce() {
		Assert.assertEquals(1, KMPPatternMatch.search("hello", "e"));
		Assert.assertEquals(1, KMPPatternMatch.search("testing", "est"));
	}
	
	@Test
	public void testExistsTwice() {
		Assert.assertEquals(2, KMPPatternMatch.search("hello", "l"));
	}

}
