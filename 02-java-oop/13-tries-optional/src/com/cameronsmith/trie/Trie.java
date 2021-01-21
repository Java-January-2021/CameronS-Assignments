package com.cameronsmith.trie;
import java.util.Set;

public class Trie {
	public Node root;
    public Trie() {
        this.root = new Node();
    }
    public void insertWord(String word) {
    	Node currentNode = this.root;// gets the root node;
        for(int i = 0; i < word.length(); i++) {// iterates over every character in the word
            // currentLetter is just the character / letter at the iteration
            Character currentLetter = word.charAt(i);
            // ask if the current letter is in the map of the current node
            Node child = currentNode.children.get(currentLetter);
            if(child == null) {
                child = new Node();
                currentNode.children.put(currentLetter, child);
            }
            currentNode = child;
        }
        currentNode.isCompleteWord = true;
    }
    public void printAllKeys() {//This method prints all the characters in your trie.
    	Character temp = null;
    	Set<Character> keys = this.root.children.keySet();
        for(Character key : keys) {
            System.out.println(key);
            temp = key;
            }
        Set<Character> keys1 = this.root.get(temp).children.keySet();
        for(Character key1 : keys1) {
        	System.out.println(key1);
        }
    }
    //Returns a boolean whether the prefix is in the trie or not.
    public boolean isPrefixValid(String prefix) {
    	boolean isPrefix = false;
    	return isPrefix;
    }
    //Returns a boolean whether the word is in the trie or not.
    public boolean isWordValid(String word) {
    	boolean isCompleteWord = false;
    	return isCompleteWord;
    }
}

