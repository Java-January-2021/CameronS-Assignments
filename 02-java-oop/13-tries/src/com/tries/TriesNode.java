package com.tries;
import java.util.HashMap;

public class TriesNode {
	public HashMap<Character, TriesNode> children;
    public boolean isCompleteWord;
    
    public TriesNode() {
        this.children = new HashMap<Character, TriesNode>();
        this.isCompleteWord = false;
    }
}
