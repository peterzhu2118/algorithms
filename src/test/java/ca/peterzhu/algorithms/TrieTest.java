package ca.peterzhu.algorithms;

import org.junit.Assert;

import org.junit.Test;

public class TrieTest {	
	@Test
	public void testHasPrefix() {
		Trie trie = new Trie();
		trie.addString("abc");
		trie.addString("abgl");
		trie.addString("cdf");
		trie.addString("abcd");
		trie.addString("lmn");
		
		Assert.assertEquals(true, trie.hasPrefix("ab"));
		Assert.assertEquals(false, trie.hasPrefix("lo"));
		Assert.assertEquals(true, trie.hasPrefix("lmn"));
	}
	
	@Test
	public void testHasString() {
		Trie trie = new Trie();
		trie.addString("abc");
		trie.addString("abgl");
		trie.addString("cdf");
		trie.addString("abcd");
		trie.addString("lmn");
		
		Assert.assertEquals(true, trie.hasString("lmn"));
		Assert.assertEquals(false, trie.hasString("ab"));
		Assert.assertEquals(true, trie.hasString("cdf"));
		Assert.assertEquals(false, trie.hasString("ghi"));
	}
	
	@Test
	public void testDelete() {
		Trie trie = new Trie();
		trie.addString("abc");
		trie.addString("abgl");
		trie.addString("cdf");
		trie.addString("abcd");
		trie.addString("lmn");
		
		Assert.assertEquals(true, trie.delete("lmn"));
		Assert.assertEquals(false, trie.delete("def"));
		
		Assert.assertEquals(false, trie.hasString("lmn"));
		Assert.assertEquals(false, trie.hasString("ab"));
		Assert.assertEquals(true, trie.hasString("cdf"));
		Assert.assertEquals(false, trie.hasString("ghi"));
	}
}
