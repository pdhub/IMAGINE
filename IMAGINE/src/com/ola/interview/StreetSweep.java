package com.ola.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class StreetSweep {

	public static char ASCI_GRAPH[][];
	public static Scanner in = new Scanner(System.in);
	public static List<String> ar[];
	static boolean visited[];
	public static void main(String[] args) {
		
			String matrixSize[] = in.nextLine().split(" ");
			int rowSize = Integer.valueOf(matrixSize[0]);
			int columnSize = Integer.valueOf(matrixSize[1]);
			
			in.nextLine();
			ar = new ArrayList[(rowSize*columnSize)+1];
			visited = new boolean[(rowSize*columnSize)+1];
			
			ASCI_GRAPH= new char[rowSize*2-1][columnSize*2-1];
			
			
				for (int i = 0; i < (rowSize*2)-1; i++) {
					ASCI_GRAPH[i]= in.nextLine().toCharArray();
				}
			
			
			
			for (int j = 1; j < ar.length; j++) {
				ar[j]= new ArrayList();
			}
			
			for (int i = 0; i < rowSize*2-1; i++) {
				for (int j = 0; j < columnSize*2-1; j++) {
					System.out.print(ASCI_GRAPH[i][j]);
				}
				System.out.println();
			}
			
			/*for (int j = 0; j < edges; j++) {
				String[] input = in.nextLine().split(" ");
				int node1 = Integer.valueOf(input[0]);
				int node2 = Integer.valueOf(input[1]);
				ar[node1].add(node2);
				ar[node2].add(node1);
						
			}*/
			
			int startingNode = Integer.valueOf(in.nextLine());
			
			calculateMininum(startingNode);
	
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
			/*for (int i = 0; i < ar[node].size(); i++) {
				if(!visited[ar[node].get(i)]){
					
					visited[ar[node].get(i)]=true;
									
					que.add(ar[node].get(i));
					//return Math.min(calculateMininum(startingNode));
				}
				
			}
			*/
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

