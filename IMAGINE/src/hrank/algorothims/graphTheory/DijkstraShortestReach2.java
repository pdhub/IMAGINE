package hrank.algorothims.graphTheory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class DijkstraShortestReach2 {

	public static List<Vertex> vertices;
	public static List<Edge> edges;
	
	public static Set<Vertex> settledNodes;
	public static Set<Vertex> unsettledNodes;
	
	public static Map<Vertex, Integer> distanceMap;
	public static Map<Vertex, Vertex> predecessorMap;
	
	private int getDistance(Vertex node, Vertex target) {
	    for (Edge edge : edges) {
	      if (edge.getSource().equals(node)
	          && edge.getDestination().equals(target)) {
	        return edge.getWeight();
	      }else if(edge.getSource().equals(target)
		          && edge.getDestination().equals(node)){
	    	  return edge.getWeight();
	      }
	    }
	    throw new RuntimeException("Should not happen");
	  }
	
	private boolean isSettled(Vertex destination) {
		
		//System.out.println("Is Node "+destination.id + " settled ? " +settledNodes.contains(destination));
		return settledNodes.contains(destination);
	}
	
	public List<Vertex> getNeighbours(Vertex node){
		List<Vertex> neighbors = new ArrayList<Vertex>();
	    
		for (Edge edge : edges) {
	      if (edge.getSource().equals(node)
	          && !isSettled(edge.getDestination())) {
	        neighbors.add(edge.getDestination());
	      }else if(edge.getDestination().equals(node) && !isSettled(edge.getSource())){
	    	  neighbors.add(edge.getSource());
	      }
	    }
	    return neighbors;
	}
	
	public void findMinimalDistancesFromSettledNode(Vertex node){
		List<Vertex> adjacentNodes = getNeighbours(node);
		
		for (Vertex target : adjacentNodes) {
		      if (getShortestDistanceToThisNodeFromSource(target) > getShortestDistanceToThisNodeFromSource(node)
		          + getDistance(node, target)) {
		        distanceMap.put(target, getShortestDistanceToThisNodeFromSource(node) + getDistance(node, target));
		        predecessorMap.put(target, node);
		        unsettledNodes.add(target);
		      }
		    }
		
	}
	
	/*** Finding min distace among unsettled start **/
	
	public Integer getShortestDistanceToThisNodeFromSource(Vertex v){
		Integer distance = distanceMap.get(v);
		if(distance==null){
			return Integer.MAX_VALUE;
		}else
			return distance;
	}
	
	public Vertex getMinimumDistanceNodeFromUnsettled(Set<Vertex> unsettledNodes){
		Vertex minimum = null;
		for(Vertex vertex:unsettledNodes){
			if(minimum==null){
				minimum=vertex;
			}else if(getShortestDistanceToThisNodeFromSource(vertex)<getShortestDistanceToThisNodeFromSource(minimum)){
				minimum = vertex;
			}
		}
		return minimum;
	}
	/*** Finding min distace among unsettled end**/
	
	public void execute (Vertex source){
		settledNodes = new HashSet<Vertex>();
		unsettledNodes = new HashSet<Vertex>();
		
		distanceMap = new HashMap<Vertex, Integer>();
		predecessorMap = new HashMap<Vertex, Vertex>();
		
		unsettledNodes.add(source);
		distanceMap.put(source, 0);
		
		while(unsettledNodes.size()>0){
			Vertex node = getMinimumDistanceNodeFromUnsettled(unsettledNodes);
			
			settledNodes.add(node);
			//System.out.println("Added : "+node.id +" to settled Nodes : Settled Node size is : "+settledNodes.size());
			unsettledNodes.remove(node);
			
			findMinimalDistancesFromSettledNode(node);			
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.valueOf(in.nextLine());
		for (int i = 0; i < testCases; i++) {
			String[] vertEdgs = in.nextLine().split(" ");
			int vertxCnt = Integer.valueOf(vertEdgs[0]);
						
			vertices = new ArrayList<Vertex>();
			edges = new ArrayList<Edge>();
			
			for (int j = 0; j < vertxCnt; j++) {
				String[] data = in.nextLine().split(" ");
				Vertex v1 = new Vertex(Integer.parseInt(data[0]),data[0]+j);
				Vertex v2 = new Vertex(Integer.parseInt(data[1]),data[1]+j);
				
				vertices.add(v1);vertices.add(v2);
				
				Edge e = new Edge(j,v1,v2,Integer.valueOf(data[2]));
				edges.add(e);
				
			}
			int startEdge = Integer.valueOf(in.nextLine());
			
			for (Vertex v : vertices) {
				if(v.id == startEdge){
					new DijkstraShortestReach2().execute(v);
					break;
				}
			}
			
			printDistanceOfAllNodesFromSourcePath();
			
		}
	}

	private static void printDistanceOfAllNodesFromSourcePath() {
		SortedSet<Vertex> keys = new TreeSet<Vertex>(distanceMap.keySet());
		for (Vertex key : keys) { 
		   Integer value = distanceMap.get(key);
		   //System.out.println("Distance to : "+key.id +" is "+value);
		   if(value!=0)
			   System.out.print(value+" ");
		   
		}
		
	}

}

class Edge{
	public int id;
	public Vertex source, destination;
	public int weight;
	public Edge(int id, Vertex source, Vertex destination, int weight){
		this.source = source;
		this.destination = destination;
		this.weight = weight;
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Vertex getSource() {
		return source;
	}
	public void setSource(Vertex source) {
		this.source = source;
	}
	public Vertex getDestination() {
		return destination;
	}
	public void setDestination(Vertex destination) {
		this.destination = destination;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}