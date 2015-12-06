package hpd.datastructures.trie;

public class Trie {

	private TrieNode root;
	private int count;
	
	public Trie() {
		root = new TrieNode();
		count = 0;
	}
	
	public void add(String key){
		String keyToLower = key.toLowerCase();
		TrieNode currNode = this.root;
		this.count++;
		for (int i = 0; i < keyToLower.length(); i++) {
			int characterKeyPos = keyToLower.charAt(i) - 'a';
			//System.out.println(characterKeyPos);
			if(currNode.children[characterKeyPos]==null){
				currNode.children[characterKeyPos] = new TrieNode();
			}
			currNode=currNode.children[characterKeyPos];
		}
		currNode.val=count;
	}
	
	public boolean search(String key){
		String keyToLower = key.toLowerCase();
		TrieNode currNode = this.root;
		for (int i = 0; i < keyToLower.length(); i++) {
			int characterKeyPos = keyToLower.charAt(i) - 'a';
			//System.out.println(characterKeyPos);
			if(currNode.children[characterKeyPos]==null){
				return false;
			}
			currNode=currNode.children[characterKeyPos];
		}
		return currNode.val!=0;
	}
}
