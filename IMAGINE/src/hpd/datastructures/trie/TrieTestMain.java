package hpd.datastructures.trie;

public class TrieTestMain {
	public static void main(String[] args) {

		String[] keys = new String[] { "A", "ans", "and", "an", "Pineapple",
				"Apple", "Orange", "Banana" };
		Trie t = new Trie();
		for (String k : keys) {
			t.add(k);
		}
		System.out.println(t.search("range"));
	}
}
