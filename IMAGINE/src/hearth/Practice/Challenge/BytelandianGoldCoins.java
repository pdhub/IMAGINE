package hearth.Practice.Challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BytelandianGoldCoins {

	public static Map map;
	public static long exchange(int coinVal){
		
		if(coinVal == 0 || coinVal == 1){
    		return coinVal;
    	}
    	
    	if(map.containsKey(coinVal)){
            return (long) map.get(coinVal);
        }
		
        long sum = Math.max(coinVal,exchange(coinVal/2) + exchange(coinVal/3) + exchange(coinVal/4));
        map.put(coinVal,sum);
        return (long) map.get(coinVal);
		
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int num=Integer.valueOf(in.nextLine());
			map = new HashMap();
			System.out.println(exchange(num));
		}
		

	}

}
