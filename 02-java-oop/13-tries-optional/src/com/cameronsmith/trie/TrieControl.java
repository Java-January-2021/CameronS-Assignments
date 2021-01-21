package com.cameronsmith.trie;

public class TrieControl {

	public static void main(String[] args) {
		Trie trie = new Trie();
        trie.insertWord("car");
        trie.insertWord("card");
        trie.insertWord("chip");
        trie.insertWord("trie");
        trie.insertWord("try");
        trie.printAllKeys();
	}

}
