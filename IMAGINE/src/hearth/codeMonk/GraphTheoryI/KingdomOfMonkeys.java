package hearth.codeMonk.GraphTheoryI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class KingdomOfMonkeys {

	public static List<Integer> graph[];
	public static int[] bananas;
	public static Boolean[] visited;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.valueOf(in.nextLine());
		for (int i = 0; i < testCases; i++) {
			String[] input =in.nextLine().split(" ");
			int monkeySize = Integer.valueOf(input[0]);
			int rituals = Integer.valueOf(input[1]);
			
			graph = new ArrayList[monkeySize+1];
			for (int j = 0; j < graph.length; j++) {
				graph[j]= new ArrayList<Integer>();
			}
			bananas = new int[monkeySize+1];
			visited = new Boolean[monkeySize+1];
			Arrays.fill(visited, false);
			
			for (int j = 0; j < rituals; j++) {
				String[] rits = in.nextLine().split(" ");
				
				Integer monk1= Integer.valueOf(rits[0]);
				Integer monk2= Integer.valueOf(rits[1]);
				
				graph[monk1].add(monk2);
				graph[monk2].add(monk1);
			}
			
			String[] bananaVal = in.nextLine().split(" ");
			for (int j = 1; j < bananaVal.length; j++) {
				bananas[j]=Integer.valueOf(bananaVal[j]);
			}
			
			System.out.println(calculate());
		}

	}
	
	public static int calculate(){
		int maxsum=0;
		for (int i = 1; i < graph.length; i++) {
			if(!visited[i]){
				int sum = dodfs(i);
				if(sum>maxsum)
					maxsum=sum;
			}
		}
		return maxsum;
	}

	private static int dodfs(int i) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(i);
		int sum=bananas[i];
		visited[i]=true;
		while(!stack.isEmpty()){
			int node = stack.pop();
			for (int j = 0; j < graph[node].size(); j++) {
				if(!visited[graph[node].get(j)]){
					visited[graph[node].get(j)]=true;
					stack.push(graph[node].get(j));
					sum +=bananas[graph[node].get(j)];
					
				}
			}
		}
		return sum;
	}

}
