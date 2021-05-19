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
	public void testKeys() {
		
		String key = ("x-rapidapi-key", "54781b218dmsh179859cdc308473p1c3856jsn1f21f1b2e12f");
		String response =("https://ebay-com.p.rapidapi.com/products/647865100010");
		 header("x-rapidapi-host", "ebay-com.p.rapidapi.com");
		toString();
		System.out.println(response.getBytes());
	}
	private void header(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

}
