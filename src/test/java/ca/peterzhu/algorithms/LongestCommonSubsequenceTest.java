package ca.peterzhu.algorithms;

import org.junit.Assert;
import org.junit.Test;


public class LongestCommonSubsequenceTest {
	
	@Test
	public void testSubsequence() {
		Assert.assertEquals("abcf", LongestCommonSubsequence.compute("abcdaf", "acbcf"));
		Assert.assertEquals("", LongestCommonSubsequence.compute("", "acbcf"));
		Assert.assertEquals("ABd", LongestCommonSubsequence.compute("ABCde", "eABdg"));
	}

}
