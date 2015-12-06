package hrank.algorothims.graphTheory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstSearchShortestReach {

	public static List<Integer> ar[];
	static boolean visited[];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tests = Integer.valueOf(in.nextLine());
		for (int i = 0; i < tests; i++) {
			String nodesEdges[] = in.nextLine().split(" ");
			int nodes = Integer.valueOf(nodesEdges[0])+1;
			int edges = Integer.valueOf(nodesEdges[1]);
			
			ar = new ArrayList[nodes+1];
			visited = new boolean[nodes+1];
			
			for (int j = 1; j < ar.length; j++) {
				ar[j]= new ArrayList();
			}
			
			for (int j = 0; j < edges; j++) {
				String[] input = in.nextLine().split(" ");
				int node1 = Integer.valueOf(input[0]);
				int node2 = Integer.valueOf(input[1]);
				ar[node1].add(node2);
				ar[node2].add(node1);
						
			}
			
			int startingNode = Integer.valueOf(in.nextLine());
			
			calculateMininum(startingNode);
					
		}

	}
	private static void calculateMininum(int startingNode) {
		//We are to find if any unreached node is there.
		Queue<Integer> que = new LinkedList<Integer>();
		
		int[] distances = new int[ar.length-1];
		
		for (int i = 0; i < distances.length; i++) {
			distances[i]=0;
		}
		
		que.add(startingNode);
		
		visited[startingNode]=true;
		
		while(!que.isEmpty()){
			int node = que.poll();
			for (int i = 0; i < ar[node].size(); i++) {
				if(!visited[ar[node].get(i)]){
					
					visited[ar[node].get(i)]=true;
									
					//if((distances[ar[node].get(i)]!=0) && (distances[ar[node].get(i)])>(6+distances[node]))
						distances[ar[node].get(i)]=6+distances[node];
											
					
					que.add(ar[node].get(i));
				}
				
			}
			
		}
		
		for (int i = 0; i < distances.length; i++) {
			System.out.print(distances[i]+" ");
		}
		System.out.println("-----");
		
		for (int i = 1; i < distances.length; i++) {
			if(i!=startingNode){
				System.out.print(distances[i]>0?distances[i]:-1);
				System.out.print(" ");
			}
		}
	}

}
