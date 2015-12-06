package com.hearth.intalio;

public class SubVector extends MyVector {

	public SubVector() {
		i = 4;
	}

	public static void main(String[] args) {
		MyVector c = new SubVector();

		long a[] = { 3, 4, 5 };
		System.out.println(a[0] + a[1] + "");

		String s = "sleop";

		System.out.println(fix(s));
	}

	private static String fix(String s) {
		s = s + "d";
		return s;
	}
	
	BAr b = new BAr();

}

class Foo {

	class BAr {

	}
}