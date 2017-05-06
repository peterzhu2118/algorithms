package ca.peterzhu.algorithms;

import org.junit.Assert;
import org.junit.Test;


public class LongestCommonSubstringTest {
	
	@Test
	public void testSubstring() {
		Assert.assertEquals("abcd", LongestCommonSubstring.compute("abcdefg", "defabcdk").str);
		Assert.assertEquals("BCd", LongestCommonSubstring.compute("eBCde", "acdBCdx").str);
	}
	
	@Test
	public void testLocation() {
		Assert.assertEquals(0, LongestCommonSubstring.compute("abcdefg", "defabcdk").str1Loc);
		Assert.assertEquals(3, LongestCommonSubstring.compute("abcdefg", "defabcdk").str2Loc);
		Assert.assertEquals(1, LongestCommonSubstring.compute("eBCde", "acdBCdx").str1Loc);
		Assert.assertEquals(3, LongestCommonSubstring.compute("eBCde", "acdBCdx").str2Loc);
	}

}
