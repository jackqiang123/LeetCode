package problem208;
//Implement a trie with insert, search, and startsWith methods.
//
//Note:
//You may assume that all inputs are consist of lowercase letters a-z.
class TrieNode {
    // Initialize your data structure here.
    public TrieNode() {
        
    	nodeset = new TrieNode[26];
    	
    	marked = false;
    	
    }
     TrieNode nodeset[];
     boolean marked;
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
 
    	insert(word,root);
    	      
    }

    private void insert(String word, TrieNode root2) {
    
    	char c = word.charAt(0);
		if (root2.nodeset[c-'a'] == null)
			root2.nodeset[c-'a'] = new TrieNode();
		if (word.length() == 1) 
			root2.nodeset[c-'a'].marked = true;
		else
			insert(word.substring(1),root2.nodeset[c-'a']);
		
	}

	// Returns if the word is in the trie.
    public boolean search(String word) {
    	if (word.length()==0) return true;
        return search(word,root);
    }

    private boolean search(String word, TrieNode root2) {
		char c = word.charAt(0);
		if (root2.nodeset[c-'a'] == null) return false;
		else if (word.length() == 1) return root2.nodeset[c-'a'].marked;
		else return search(word.substring(1),root2.nodeset[c-'a']);
		
	}

	// Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	if (prefix.length()==0) return true;
        return startsWith(prefix,root);
    }

	private boolean startsWith(String prefix, TrieNode root2) {
		char c = prefix.charAt(0);
	//	System.out.println("here");
		if (root2.nodeset[c-'a'] == null) return false;
		else if (prefix.length() == 1) {return (root2.nodeset[c-'a'] != null);}
		else return startsWith(prefix.substring(1),root2.nodeset[c-'a']);
	}
	public static void main(String []args)
	{
		Trie trie = new Trie();
		trie.insert("s");
		System.out.println(trie.search("a"));
	}
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");