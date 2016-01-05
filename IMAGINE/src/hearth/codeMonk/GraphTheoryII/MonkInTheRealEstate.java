package hearth.codeMonk.GraphTheoryII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MonkInTheRealEstate {

	
	public static List<Integer> graph[];
	public static Boolean[] visited;
	public static int cityCount = 0;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.valueOf(in.nextLine());
		for (int i = 0; i < testCases; i++) {
			int numRoads = Integer.valueOf(in.nextLine());
			
			graph= new ArrayList[numRoads+1];
			visited = new Boolean[numRoads+1];
			Arrays.fill(visited, false);
			
			for (int j = 0; j < graph.length; j++) {
				graph[j] = new ArrayList();
			}
			
			for (int j = 0; j < numRoads; j++) {
				String[] inpt = in.nextLine().split(" ");
				Integer road1 = Integer.valueOf(inpt[0]);
				Integer road2 = Integer.valueOf(inpt[1]);
				
				graph[road1].add(road2);
				graph[road2].add(road1);
								
			}
			
			calculateCities();
			System.out.println(cityCount);
			
		}

	}

	private static void calculateCities() {
		for (int i = 1; i < graph.length; i++) {
			if(!visited[i])
				dodfs(i);
		}
		
	}

	private static void dodfs(int i) {
		Stack<Integer> s= new Stack<Integer>();
		s.push(i);
		visited[i]=true;
		cityCount++;
		while(!s.isEmpty()){
			int node = (int) s.pop();
			for (int j = 0; j < graph[node].size(); j++) {
				if(!visited[graph[node].get(j)]){
					cityCount++;
					visited[graph[node].get(j)]=true;
					s.push(graph[node].get(j));
				}
			}
			
		}
		
	}

}
