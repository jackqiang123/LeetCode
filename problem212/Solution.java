package problem212;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

//Given a 2D board and a list of words from the dictionary, find all words in the board.
//
//Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. T
//he same letter cell may not be used more than once in a word.
//
//For example,
//Given words = ["oath","pea","eat","rain"] and board =
//
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//Return ["eat","oath"].
//Note:
//You may assume that all inputs are consist of lowercase letters a-z.
//
//click to show hint.
//
//You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?
//
//If the current candidate does not exist in all words' prefix, you could stop backtracking immediately.
//What kind of data structure could answer such query efficiently? Does a hash table work? Why or why not? How about a Trie?
//If you would like to learn how to implement a basic trie, please work on this problem: Implement Trie (Prefix Tree) first.

class TrieNode {
	boolean isEndOfWord;
	TrieNode[] children;

	// Initialize your data structure here.
	public TrieNode() {
		this.isEndOfWord = false;
		this.children = new TrieNode[26];
	}
}

class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNode runner = root;
		for (char c : word.toCharArray()) {
			if (runner.children[c - 'a'] == null) {
				runner.children[c - 'a'] = new TrieNode();
			}
			runner = runner.children[c - 'a'];
		}
		runner.isEndOfWord = true;
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode runner = root;
		for (char c : word.toCharArray()) {
			if (runner.children[c - 'a'] == null) {
				return false;
			} else {
				runner = runner.children[c - 'a'];
			}
		}
		return runner.isEndOfWord;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode runner = root;
		for (char c : prefix.toCharArray()) {
			if (runner.children[c - 'a'] == null) {
				return false;
			} else {
				runner = runner.children[c - 'a'];
			}
		}
		return true;
	}
}

public class Solution {
	public static List<String> findWords(char[][] board, String[] words) {
		Trie mytrie = new Trie();
		for (String s : words)
			mytrie.insert(s);
		List<String> r = new LinkedList<String>();
		HashSet<String> result = new HashSet<String>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				boolean[][] visited = new boolean[board.length][board[0].length];
				StringBuilder cur = new StringBuilder();
				dfs(board, cur, mytrie, visited, i, j, result);
			}
		}
		for (String s : result)
		{
			r.add(s);
		}
		return r;

	}

	private static void dfs(char[][] board, StringBuilder cur, Trie mytrie,
			boolean[][] visited, int i, int j, HashSet<String> result) {
		// TODO Auto-generated method stub
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
			return; // return since invalid index
		if (visited[i][j])
			return; // return since
		cur.append(board[i][j]);
		visited[i][j] = true;
		if (mytrie.search(cur.toString()))
			result.add(cur.toString());
		if (!mytrie.startsWith(cur.toString())) {
			cur.deleteCharAt(cur.length() - 1);
			visited[i][j] = false;
			return; // return due to no prefix
		}

		dfs(board, cur, mytrie, visited, i - 1, j, result);
		dfs(board, cur, mytrie, visited, i + 1, j, result);
		dfs(board, cur, mytrie, visited, i, j - 1, result);
		dfs(board, cur, mytrie, visited, i, j + 1, result);

		cur.deleteCharAt(cur.length() - 1);
		visited[i][j] = false;

	}

	public static void main(String[] args) {
		char[][] c = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' },
				{ 'i', 'h', 'k', 'r' }, { 'i', 'f', 'l', 'v' } };
		String[] word = { "oath", "pea", "eat", "rain" };
		List<String> l = findWords(c, word);
		for (String s : l)
			System.out.println(s);

	}

}
