package problem211;

//Design a data structure that supports the following two operations:
//
//void addWord(word)
//bool search(word)
//search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
//
//For example:
//
//addWord("bad")
//addWord("dad")
//addWord("mad")
//search("pad") -> false
//search("bad") -> true
//search(".ad") -> true
//search("b..") -> true
//Note:
//You may assume that all words are consist of lowercase letters a-z.

class TrieNode {
	// Initialize your data structure here.
	public TrieNode() {

		nodeset = new TrieNode[26];

		marked = false;

	}

	TrieNode nodeset[];
	boolean marked;
}

public class WordDictionary {

	private TrieNode root;

	public WordDictionary() {
		root = new TrieNode();
	}

	// Adds a word into the data structure.
	public void addWord(String word) {
		insert(word, root);
	}

	private void insert(String word, TrieNode root2) {

		char c = word.charAt(0);
		if (root2.nodeset[c - 'a'] == null)
			root2.nodeset[c - 'a'] = new TrieNode();
		if (word.length() == 1)
			root2.nodeset[c - 'a'].marked = true;
		else
			insert(word.substring(1), root2.nodeset[c - 'a']);

	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		return search(word, root);
	}

	public boolean search(String word, TrieNode root2) {
		char c = word.charAt(0);
		if (word.length() == 1) {
			if (c == '.') {
				for (int i = 0; i < 26; i++) {

					// System.out.println("last bit with c == . " + i +"----"
					// +(root2.nodeset[i]!=null));
					// if (i == 22) System.out.println(root2.nodeset[i].marked);
					if (root2.nodeset[i] != null && root2.nodeset[i].marked)
						return true;

				}
				return false;
			} else
				return (root2.nodeset[c - 'a'] != null)
						&& (root2.nodeset[c - 'a'].marked);
		} else {
			if (c == '.') {
				for (TrieNode n : root2.nodeset) {
					if (n != null && search(word.substring(1), n))
						return true;
				}
				return false;
			} else {
				return (root2.nodeset[c - 'a'] != null)
						&& (search(word.substring(1), root2.nodeset[c - 'a']));
			}

		}

	}

	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("w");
		System.out.println(wordDictionary.search("."));
	}
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");