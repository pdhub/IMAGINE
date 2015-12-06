package hearth.Code.Monk.bit.manipulation;

public class MonksChoiceofNumbers {

	public static void main(String[] args) {
		String s = stringToBin(466666666);
		int num=12;
		System.out.println();
		StringBuilder output = new StringBuilder();
		while(num != 0) {
		  output.append(num & 1);
		  num >>>= 1;    
		}
		
		System.out.println(output);
		
		System.out.println(s);
	}
	
	public static String stringToBin(Integer num){
		String retVal = "";
		while(num>0){
			int rem = num%2;
			retVal=rem+retVal;
			num=num/2;
		}
		return retVal;
	}
	
	public static String stringToBinByShifting(Integer num){
		String retVal = "";
		while(num>0){
			int rem = num%2;
			retVal=rem+retVal;
			num=num/2;
		}
		return retVal;
	}

}
