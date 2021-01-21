package com.cameronsmith.trie;

import java.util.HashMap;

public class Node {
	public HashMap<Character, Node> children;
    public boolean isCompleteWord;

    public Node() {
        this.children = new HashMap<Character, Node>();
        this.isCompleteWord = false;
    }

	public Object get(Character temp) {
		// TODO Auto-generated method stub
		return null;
	}
}
