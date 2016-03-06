package hearth.capillary;

import java.util.TreeMap;

public class TEst {
	public static void main(String[] args) {
		TreeMap m = new TreeMap();
		m.put("a", "b");
		int a = 1, b = 2, c = 3;
		a |= 4;
		c <<= 1;
		b >>= 1;
		a ^= c;
		System.out.println(b + " : " + c);
		String s = "Foolish x";
		System.out.println(s.indexOf("Fool"));
		int i = 25;
		double d = 225.50;
		i = (int) d;
		System.out.println(i);

		int x;
		x = 2;
		if (x != 2 && x / 0 == 4) {

		}

	}
}
