/**A sequence of integers is called a beautiful sequence if all the integers in it are positive and it is a strictly increasing sequence.

Given a sequence of integers, you have to make it a beautiful sequence. For that you can change any element you want, but you should make as less changes as possible in order to make it a beautiful sequence.

Input

The first line of input is an integer T(T <= 5), the number of test cases. Each test case contains 2 lines.

The first line of the test case contains an integer (0 < N <= 100000), i.e. the number of elements in the original sequence.

The second line contains N positive integers, no larger than 2000000000, which forms the original sequence.

Output

For each test case output the minimal number of elements you must change in the original sequence to make it a beautiful sequence.

Explanation for sample Input/Output

For the 1st test case you needn't to change any elements. 
For the 2nd test case you can change 3 into 1 and change 1 into 3. 
For the 3rd test case you can change 10 into 1. 
For the 4th test case you can change the last three 2s into 3,4 and 5.*/

package hearth.hacker.weekly.abacus;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BeautifulSequence {

	public static void main(String[] args) throws Exception {
		
		/*String str1 = "12345446546";
		String str2 = "1234546546";
		 System.out.println(compareStrings(str1, str2));*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		int N = Integer.parseInt(line);
		for (int i = 1; i <= N; i++) {
			
			br.readLine();
			String[] str = br.readLine().split(" ");
			//System.out.println("Processing : "+i+"th"+ "input" +str);
			beautify(str);
		}

	}

	private static void beautify(String[] str) {
		int count = 0;
		for (int i = 0; i < str.length; i++) {
			if(i!=str.length-1 && compareStrings(str[i],str[i+1]))
				count++;
		}
		System.out.println(count);
	}

	private static boolean compareStrings(String str1, String str2) {
		boolean retval = false;
		//retval = string.compareTo(string2);
		if(str1.length() > str2.length() || str1.equals(str2)){
			retval = true;
			return retval;
		}
		else if(str1.length() == str2.length()){
			for (int i = 0; i < str1.length(); i++) {
				//System.out.println("3 grate ? "+str1.charAt(i)+" "+str2.charAt(i));
				if(str1.charAt(i)>str2.charAt(i)){
					
					retval =true;
					break;
				}
			}
		}
		return retval;
	}

}
