package hrank.algorothims.graphTheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DijkstraShortestReach2 {

	public static List<Vertex> vertices;
	public static List<Edge> edges;
	public static Set settledNode;
	public static Set unsettledNode;
	
	
	public static void findAllShortestPathsFrom(Vertex source){
		
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.valueOf(in.nextLine());
		for (int i = 0; i < testCases; i++) {
			String[] vertEdgs = in.nextLine().split(" ");
			int vertxCnt = Integer.valueOf(vertEdgs[0]);
			int edgeCnt = Integer.valueOf(vertEdgs[1]);
			
			vertices = new ArrayList<Vertex>();
			edges = new ArrayList<Edge>();
			for (int j = 0; j < vertxCnt; j++) {
				Vertex v = new Vertex(j, "Node+"+j);
				
			}
			
		}
	}

}
