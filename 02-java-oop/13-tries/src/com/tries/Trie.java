package com.tries;

public class Trie {
public TriesNode root;
    
    public Trie() {
        this.root = new TriesNode();
    }
    
    public void insertWord(String word) {
        // gets the root node;
    	TriesNode currentNode = this.root;
        
        // iterates over every character in the word
        for(int i = 0; i < word.length(); i++) {
            // currentLetter is just the character / letter at the iteration
            Character currentLetter = word.charAt(i);
            // ask if the current letter is in the map of the current node
            TriesNode child = currentNode.children.get(currentLetter);
            if(child == null) {
                child = new TriesNode();
                currentNode.children.put(currentLetter, child); 
            } 
            
            currentNode = child;
        }
        currentNode.isCompleteWord = true;
    }
}
