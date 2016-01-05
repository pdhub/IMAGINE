package hearth.NationalInstruments;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CrazyNumbers {

	public static void calculate(Integer len){
		
		
		Set<String> crazyNums = new HashSet<String>();
		String numFrom="1", numTo="9";
		if(len==1)
			numFrom="0";
		for (int i = 1; i < len; i++) {
			numFrom+=0;
			numTo+=9;
		}
		
		/*Integer numFromInt = Integer.valueOf(numFrom);
		Integer numToInt = Integer.valueOf(numTo);*/
		
		//System.out.println(numFrom+" : "+numTo);
		
		while(!numFrom.equals(numTo)){
			
			boolean canAdd = checkNum(numFrom);
			if(canAdd && !crazyNums.contains(numFrom)){
				crazyNums.add(numFrom);
			}
			//System.out.println("Adding : "+numFrom);
			numFrom = add(numFrom, "1");
			
		}
		boolean canAdd = checkNum(numFrom);
		if(canAdd && !crazyNums.contains(numFrom)){
			crazyNums.add(numFrom);
		}
		//System.out.println("Adding : "+numFrom);
		//numFrom = add(numFrom, "1");
		
		Integer size = crazyNums.size();
		
		Integer res = (int) (size%(Math.pow(10, 9)+7));
		
		System.out.println(res);
		
				
	}
	
	private static boolean checkNum(String num) {
		
		
		for (int j = 0; j+1 < num.length(); j++) {
			
			Integer x = Integer.valueOf(num.charAt(j)+"");
			Integer y = Integer.valueOf(num.charAt(j+1)+"");
			//System.out.println(x+" : "+y);
			if(Math.abs(x-y)>1 || Math.abs(x-y)==0){
				//System.out.println(" false ");
				return false;
			}
		}
		//System.out.println(" true ");
		return true;
		
	}
	
	public static String add(String addend1, String addend2) {
	    StringBuilder buf = new StringBuilder();
	    for ( int i1 = addend1.length() - 1, i2 = addend2.length() - 1, carry = 0;
	          i1 >= 0 || i2 >= 0 || carry != 0;
	          i1--, i2-- ) {
	        int digit1 = i1 < 0 ? 0 :
	                     Integer.parseInt(Character.toString(addend1.charAt(i1)));
	        int digit2 = i2 < 0 ? 0 :
	                     Integer.parseInt(Character.toString(addend2.charAt(i2)));

	        int digit = digit1 + digit2 + carry;
	        if (digit > 9) {
	            carry = 1;
	            digit -= 10;
	        } else {
	            carry = 0;
	        }

	        buf.append(digit);
	    }
	    return buf.reverse().toString();
	}

	public static void main(String[] args) {
		
	
		/*String s1 = "Hello"; 
		StringBuffer sb = new StringBuffer(s1); 
		sb.reverse(); 
		s1.concat(sb.toString()); 
		System.out.println(s1 + sb + s1.length() + sb.length()); 
		
		final int ii = 22;
		byte b =ii;
		System.out.println(ii +" : "+b);
		
		Set h = new HashSet();
	    h.add("One");
	    h.add("Two");
	    h.add("Three");
	    h.add("Four");
	    h.add("One");
	    h.add("Four");
	    List l = new ArrayList();
	    l.add("One");
	    l.add("Two");
	    l.add("Three");
	    h.retainAll(l);
	    System.out.println("Size:" + l.size()+ h.size());*/
		
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		for (int i = 0; i < testCases; i++) {
			Integer num = Integer.valueOf(in.nextLine());
			calculate(num);
		}
		

	}

	private static void calculateWithRecursion(Integer num) {
	
		
		
	}

}
