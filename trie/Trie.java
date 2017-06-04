package com.javamultiplex.datastructure.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	private class TrieNode {

		Map<Character, TrieNode> children;
		boolean endofWord;

		public TrieNode() {
			children = new HashMap<>();
			endofWord = false;
		}

	}

	private final TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Iterative version
	public void insert(String word) {
		TrieNode current = root, node = null;
		int length = word.length();
		char ch = '\u0000';
		for (int i = 0; i < length; i++) {
			ch = word.charAt(i);
			node = current.children.get(ch);
			if (node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;

		}

		current.endofWord = true;
	}

	public void insertRecursive(String word) {

		insertRecursive(root, word, 0);
	}

	// Recursive version
	private void insertRecursive(TrieNode current, String word, int index) {

		if (index == word.length()) {
			current.endofWord = true;
			return;
		}
		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		if (node == null) {
			node = new TrieNode();
			current.children.put(ch, node);
		}
		insertRecursive(node, word, index + 1);
	}

	// Iterative version
	public boolean search(String word) {

		TrieNode current = root, node = null;
		int length = word.length();
		char ch = '\u0000';
		for (int i = 0; i < length; i++) {

			ch = word.charAt(i);
			node = current.children.get(ch);
			if (node == null) {
				return false;
			}
			current = node;
		}

		return current.endofWord;
	}

	public boolean searchRecursive(String word) {
		return searchRecursive(root, word, 0);
	}

	// Recursive version
	private boolean searchRecursive(TrieNode current, String word, int index) {

		if (index == word.length()) {
			return current.endofWord;
		}

		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		if (node == null) {
			return false;
		}
		return searchRecursive(node, word, index + 1);
	}

	public boolean delete(String word) {
		return delete(root, word, 0);
	}

	private boolean delete(TrieNode current, String word, int index) {

		if (index == word.length()) {
			if (!current.endofWord) {
				return false;
			}
			current.endofWord = false;
			return current.children.size() == 0;
		}

		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		if (node == null) {
			return false;

		}

		boolean shouldDeleteCurrentNode = delete(node, word, index + 1);
		if (shouldDeleteCurrentNode) {
			current.children.remove(ch);
			return current.children.size() == 0;
		}
		return false;

	}

}
