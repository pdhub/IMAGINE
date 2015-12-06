package com.pritom.thoughtworks.assignment;
import java.util.HashMap;
import java.util.Map;

public class AlienLanguageUtil {

	public static Map<String, Integer> romanMap = new HashMap<String, Integer>();

	public static Map<String, String> alienWordToRoman = new HashMap<String, String>();

	public static Map<String, String> metalLists = new HashMap<String, String>();

	public static Map alienMetals = new HashMap();

	/**
	 * If further ROMAN mapping is found we can inout it here. It violates the
	 * condition that, a class must be closed for modification but open to
	 * extension. But for the moment i can only think of this solution
	 */
	static {
		romanMap.put("I", 1);
		romanMap.put("V", 5);
		romanMap.put("X", 10);
		romanMap.put("L", 50);
		romanMap.put("C", 100);
		romanMap.put("D", 500);
		romanMap.put("M", 1000);
	}
}
