package hpd.datastructures.trie;

public class TrieNode {

	int val;
	TrieNode[] children;
	
	public TrieNode() {
		this.val = 0;
		
		this.children = new TrieNode[26];//There are 26 letters 
		
		for (TrieNode ele : children) {
			ele = null;
		}
	}
}
