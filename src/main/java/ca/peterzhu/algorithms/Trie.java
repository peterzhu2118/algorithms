package ca.peterzhu.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of a trie data structure. Trie data structures are a type of
 * search tree that can store lists of strings very efficiently. Time complexity
 * for finding prefix or searching for a string is O(m) where m is the length of
 * the string to be searched for.
 * 
 * @author Peter Zhu
 * 
 */
public class Trie {

	private TrieNode rootNode;

	public Trie() {
		rootNode = new TrieNode();
	}

	public void addString(String str) {
		rootNode.addString(str, 0);
	}

	public boolean hasPrefix(String str) {
		return rootNode.hasPrefix(str, 0);
	}

	public boolean hasString(String str) {
		return rootNode.hasString(str, 0);
	}

	public boolean delete(String str) {
		return rootNode.delete(str, 0);
	}

	private class TrieNode {
		private Map<Character, TrieNode> children;
		private boolean endOfWord;

		public TrieNode() {
			children = new HashMap<>();
			endOfWord = false;
		}

		public Map<Character, TrieNode> getChildren() {
			return children;
		}

		public void addString(String str, int position) {
			// If this is one over the last character, put on the end of word
			// flag
			if (position == str.length()) {
				endOfWord = true;
			} else {
				Character currChar = str.charAt(position);

				// If there is a child trie node for this character, then go to
				// this child
				if (children.containsKey(currChar)) {
					TrieNode nextNode = children.get(currChar);
					nextNode.addString(str, position + 1);
				} else { // If there is not a child trie node, then create it
							// and go to it
					TrieNode nextNode = new TrieNode();
					children.put(currChar, nextNode);
					nextNode.addString(str, position + 1);
				}
			}
		}

		public boolean hasPrefix(String str, int position) {
			// If the end of the string has been reached, then the prefix exists
			if (str.length() == position) {
				return true;
			} else if (children.size() == 0 && str.length() > position) {
				// If there are no more child nodes but the end of the prefix
				// has not been reached
				return false;
			} else { // Else get the child node and continue searching
				TrieNode childNode = children.get(str.charAt(position));

				return childNode != null
						&& childNode.hasPrefix(str, position + 1);
			}
		}

		public boolean hasString(String str, int position) {
			// If the end of the string has been reached, then check if it is
			// the end of the word
			if (str.length() == position) {
				return endOfWord;
			} else {
				Character currChar = str.charAt(position);

				TrieNode childNode = children.get(currChar);

				return childNode != null
						&& childNode.hasString(str, position + 1);
			}
		}

		public boolean delete(String str, int position) {
			// If the end of the string has been reached and the end of the word
			// as also been reached, then a match has been found
			if (str.length() == position) {
				if (endOfWord == true) {
					endOfWord = false;
					return true;
				} else {
					return false;
				}
			} else {
				TrieNode childNode = children.get(str.charAt(position));

				if (childNode != null) {
					boolean deleteSuccess = childNode.delete(str, position + 1);

					if (deleteSuccess) {
						if (childNode.isEndOfWord() == false
								&& childNode.getChildren().isEmpty()) {
							children.remove(childNode);
						}

						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		}

		public boolean isEndOfWord() {
			return endOfWord;
		}

		public void setEndOfWord(boolean endOfWord) {
			this.endOfWord = endOfWord;
		}
	}
}
