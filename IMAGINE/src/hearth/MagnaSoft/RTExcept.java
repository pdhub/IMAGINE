package hearth.MagnaSoft;

public class RTExcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int i = 22;
		byte b = i;
		System.out.println(i + " : " + b);
		try {
			System.out.println("A");
			throwit();
		} catch (Exception e) {
			System.out.println("B");
		} finally {
			System.out.println("C");
		}
		System.out.println("D");
	}

	private static void throwit() {
		System.out.println("pop");
		throw new RuntimeException();
	}

}
