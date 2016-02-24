package hrank.algorothims.graphTheory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Prims {

	public static List<Vertex> vertices;
	public static List<Edge> edges;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int vertices = sc.nextInt(), edges = sc.nextInt();
		ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>(vertices + 1);
		for (int i = 0; i < vertices + 1; i++)
			adj.add(new ArrayList<Node>(vertices + 1));

		while (edges-- > 0) {
			int x = sc.nextInt(), y = sc.nextInt(), cost = sc.nextInt();
			adj.get(x).add(new Node(y, cost));
			adj.get(y).add(new Node(x, cost));
		}
		int startNode = sc.nextInt();
		prims(startNode, adj, vertices);

	}

	private static void prims(int startNode, ArrayList<ArrayList<Node>> adj, int vertices2) {
		int cost = 0;
        HashSet path = new LinkedHashSet();
        List unvisited = new ArrayList();
        Queue edgesAvailable = new PriorityQueue();
        for (int i = 1; i < vertices2; i++) {
        	unvisited.add(i);
		}
        
        unvisited.remove(startNode);
        
        while(!unvisited.isEmpty()){
        	for(Node adjNodes:adj.get(startNode)){
        		
        	}
        }
        	       
	}
}
