package hearth.vmware;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaxDifference {

	public int maxDiff(int arr[])
	{
	  int max_diff = -1;//arr[1] - arr[0];
	  int min_element = arr[0];
	  int i;
	  for(i = 1; i < arr.length; i++)
	  {       
	    if (arr[i] - min_element > max_diff)                               
	      max_diff = arr[i] - min_element;
	    if (arr[i] < min_element)
	         min_element = arr[i];                     
	  }
	  return max_diff;
	} 
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		/*int nums = Integer.valueOf(in.nextLine());
		int arr[] = new int[nums];
		for (int i = 0; i < nums; i++) {
			arr[i] =  Integer.valueOf(in.nextLine());
		}
		
		System.out.println(new MaxDifference().maxDiff(arr));*/
		
		int k = Integer.valueOf(in.nextLine());;
		int n = Integer.valueOf(in.nextLine());
		int arr[] = new int[n];
		String[] nums = in.nextLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] =  Integer.valueOf(nums[i]);
		}
		
		System.out.println(new MaxDifference().get_count(arr, k));
	}
	
	
		public long get_count(int arr[], int k) {
		    int cnt_mod[] = new int[arr.length];//(k, 0);
		    cnt_mod[0] = 1;
		    int pref_sum = 0;

		    for (int elem : arr) {
		        pref_sum += elem;
		        pref_sum %= k;
		        cnt_mod[pref_sum]++;
		    }

		    long res = 0;
		    for (int mod = 0; mod < k; mod++)
		        res += (long)cnt_mod[mod] * (cnt_mod[mod] - 1) / 2;
		    return res;
		
	}
		
		public void domains(){
					
			/*Pattern pattern = Pattern.compile("^https?://[^/]+/([^/]+)/.*$");
			for (int i = 0; i < array.length; i++) {
				Matcher matcher = pattern.matcher(url);
			    if(matcher.find())
			    {
			        System.out.println(matcher.group(1));
			    }
			}*/
			
		}
}
