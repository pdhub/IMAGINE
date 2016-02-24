/**
 *
 * Dijkstra partitions all nodes into two distinct sets. Unsettled and settled. 
 * Initially all nodes are in the unsettled sets, e.g. they must be still evaluated. 
 * A node is moved to the settled set if a shortest path from the source to this node has been found.

	
	Initially the distance of each node to the source is set to a very high value.
	
	First only the source is in the set of unsettledNodes.
	
	The algorithms runs until the unsettledNodes are empty. In earch iteration it selects the node with the lowest distance 
	from the source out the unsettled nodes. If reads all edges which are outgoing from the source and evaluates for each destination node in these edges which is not 
	yet settled if the known distance from the source to this node can be reduced if the selected edge is used. If this can be done then the distance 
	is updated and the node is added to the nodes which need evaluation.

 * */

package hrank.algorothims.graphTheory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DjikstraShortestPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestDijkstraAlgorithm().testExcute();
	}

}

/**Create the Graph*/
class Graph{
	public List<Vertex> vertices;
	public List<Edge> edges;
	public Graph(List<Vertex> vertices,List<Edge> edges ){
		this.vertices = vertices;
		this.edges = edges;
	}
}

/**The Algorithm*/
class DijkstraAlgorithm{
	
	public List<Vertex> nodes;
	public List<Edge> edges;
	
	public Set<Vertex> settledNodesSet;
	public Set<Vertex> unSettledNodesSet;
	
	private Map<Vertex, Vertex> predecessorsMap;
	private Map<Vertex, Integer> distanceMap;
	
	public DijkstraAlgorithm(Graph graph){
		nodes = new ArrayList<Vertex>(graph.vertices);
		edges = new ArrayList<Edge>(graph.edges);
	}
	
	public void execute(Vertex source){
		settledNodesSet = new HashSet<Vertex>();
	    unSettledNodesSet = new HashSet<Vertex>();
	    
	    distanceMap = new HashMap<Vertex, Integer>();
	    predecessorsMap = new HashMap<Vertex, Vertex>();//This is only to keep track of which node is the parent of which other
	    
	    distanceMap.put(source, 0);
	    unSettledNodesSet.add(source);
	    
	    while(unSettledNodesSet.size()>0){
	    	Vertex node = getVertexHavingMinDistForEachUnsettledNode(unSettledNodesSet);
	    	settledNodesSet.add(node);
	    	unSettledNodesSet.remove(node);
	    	findMinimalDistancesFromTheNode(node);
	    }
	}

	/**
	 * find the node with the lowest distance in UnSettledNodes and return it 
	 * **/
	private Vertex getVertexHavingMinDistForEachUnsettledNode(Set<Vertex> unSettledNodesSet2) {
		Vertex min = null;
		for (Vertex vertex : unSettledNodesSet2) {
			if(min==null)
				min = vertex;
			else{
				if(distanceMap.get(vertex)<distanceMap.get(min)){
					min = vertex;
				}
			}
		}
		return min;
	}
	
	/**
	 * Foreach destinationNode which can be reached via an edge from evaluationNode AND which is not in SettledNodes
	 * */
	  
	private void findMinimalDistancesFromTheNode(Vertex node) {
		List<Vertex> adjacentNodes = getNeighbors(node);
		for (Vertex target : adjacentNodes) {
		   if (distanceMap.get(target) > distanceMap.get(node) + getDistanceBtwnNodes(node, target)) {
		        distanceMap.put(target, distanceMap.get(node) + getDistanceBtwnNodes(node, target));
		        predecessorsMap.put(target, node);
		        unSettledNodesSet.add(target);
		      }
		}
		
	}

	private List<Vertex> getNeighbors(Vertex node) {
		List<Vertex> neighbors = new ArrayList<Vertex>();
		for (Edge edge : edges) {
		   if (edge.source.equals(node) && !isSettled(edge.destination)) {
		        neighbors.add(edge.destination);
		      }
		}
		return neighbors;
	}

	private boolean isSettled(Vertex destination) {
		return settledNodesSet.contains(destination);
	}
	
	private int getDistanceBtwnNodes(Vertex node, Vertex target) {
		for (Edge edge : edges) {
		   if (edge.source.equals(node) && edge.destination.equals(target)) 
		        return edge.weight;
		     
		 }
		throw new RuntimeException("Should not happen");
	}
	
	/*
	   * This method returns the path from the source to the selected target and
	   * NULL if no path exists
	   */
	  public LinkedList<Vertex> getPath(Vertex target) {
	    LinkedList<Vertex> path = new LinkedList<Vertex>();
	    Vertex step = target;
	    // check if a path exists
	    if (predecessorsMap.get(step) == null) {
	      return null;
	    }
	    path.add(step);
	    while (predecessorsMap.get(step) != null) {
	      step = predecessorsMap.get(step);
	      path.add(step);
	    }
	    // Put it into the correct order
	    Collections.reverse(path);
	    return path;
	  }
	
}

class TestDijkstraAlgorithm {

	  private List<Vertex> vertices;
	  private List<Edge> edges;

	  
	  public void testExcute() {
	    vertices = new ArrayList<Vertex>();
	    edges = new ArrayList<Edge>();
	    for (int i = 0; i < 11; i++) {
	      Vertex location = new Vertex(i, "Node_" + i);
	      vertices.add(location);
	    }

	    addEdge(0, 0, 1, 85);
	    addEdge(1, 0, 2, 217);
	    addEdge(2, 0, 4, 173);
	    addEdge(3, 2, 6, 186);
	    addEdge(4, 2, 7, 103);
	    addEdge(5, 3, 7, 183);
	    addEdge(6, 5, 8, 250);
	    addEdge(7, 8, 9, 84);
	    addEdge(8, 7, 9, 167);
	    addEdge(9, 4, 9, 502);
	    addEdge(10, 9, 10, 40);
	    addEdge(11, 1, 10, 600);

	    // Lets check from location Loc_1 to Loc_10
	    Graph graph = new Graph(vertices, edges);
	    DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
	    
	    /**Execute from the source node*/
	    dijkstra.execute(vertices.get(0));
	    
	    /**Fill the destination node*/
	    LinkedList<Vertex> path = dijkstra.getPath(vertices.get(10));
	    
	    for (Vertex vertex : path) {
	      System.out.print(vertex.id+"->");
	    }
	    
	  }

	  private void addEdge(int laneId, int sourceLocNo, int destLocNo,
	      int duration) {
	    Edge lane = new Edge(laneId,vertices.get(sourceLocNo), vertices.get(destLocNo), duration);
	    edges.add(lane);
	  }
	} 