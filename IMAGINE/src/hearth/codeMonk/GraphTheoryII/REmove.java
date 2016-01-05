package hearth.codeMonk.GraphTheoryII;

public class REmove {

	public static void main(String[] args) {
		String s = "abababccx";
		System.out.println(remove(s));

	}

	private static String remove(String input) {
		String dupremoved = "";
		int characters[] = new int[1000];
		for (int i = 0; i < input.length(); i++) {
			char c= input.charAt(i);
			characters[c]++;
		}
		for (int i = 0; i < input.length(); i++) {
			char c= input.charAt(i);
			int occurence = characters[c];
			if(occurence>0){
				dupremoved+=c+"";
				characters[c] =0;
			}
		}
		return dupremoved;
	}

}
