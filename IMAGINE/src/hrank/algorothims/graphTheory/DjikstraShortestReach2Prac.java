package hrank.algorothims.graphTheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DjikstraShortestReach2Prac {

	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		
		
		while(testCases-- >0){
			int numNodes = in.nextInt();
			int numEdges = in.nextInt();
			
			ArrayList<ArrayList<NodeDjikStra>> adj = new ArrayList<ArrayList<NodeDjikStra>>(numNodes+1); 
			
			for (int i = 0; i <= numNodes; i++) {
				adj.add(new ArrayList<NodeDjikStra>());
			}
			
			while(numEdges-- >0){
				int vertex1 = in.nextInt();
				int vertex2 = in.nextInt();
				int weight = in.nextInt();
				adj.get(vertex1).add(new NodeDjikStra(vertex2,weight));
				adj.get(vertex2).add(new NodeDjikStra(vertex1,weight));
			}
			
			int source = in.nextInt();
			doDjikStra(source,adj, numNodes);
		}
	}

	private static void doDjikStra(int source, ArrayList<ArrayList<NodeDjikStra>> adj, int numNodes) {
		
		int distance[] = new int[numNodes+1];
		Arrays.fill(distance, 0);
		PriorityQueue<NodeDjikStra> pq= new PriorityQueue<NodeDjikStra>();
		pq.add(new NodeDjikStra(source,0));
		
		distance[source] = 0;
		while(!pq.isEmpty()){
			NodeDjikStra node = pq.poll();
			int currNode = node.val;
			Iterator<NodeDjikStra> iterator = adj.get(currNode).iterator();
			while(iterator.hasNext()){
				NodeDjikStra temp = iterator.next();
				if(distance[temp.val]>distance[currNode]+temp.val){
					distance[temp.val]=distance[currNode]+temp.val;
					pq.add(new NodeDjikStra(temp.val, distance[temp.val]));
				}
			}
		}
		
		for (int i = 0; i < distance.length; i++) {
			if(i!=source)
				System.out.println(distance[i]);
		}
	}
}

class NodeDjikStra implements Comparable<NodeDjikStra>{

	int val, cost;
	NodeDjikStra(int val, int cost){
		this.val = val;
		this.cost = cost;
	}
	@Override
	public int compareTo(NodeDjikStra node) {
		
		return Integer.compare(this.cost, node.cost);
	}
	
}