package hpd.vogella.algorithms.Djikstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DijkstraAlgorithm {
	
	private final List<Vertex> nodes;
	private final List<Edge> edges;

	private Set<Vertex> settledNodes;
	private Set<Vertex> unSettledNodes;

	private Map<Vertex, Vertex> predecessors;
	private Map<Vertex, Integer> distanceMap;

	public DijkstraAlgorithm(Graph graph) {
		// create a copy of the array so that we can operate on this array
		this.nodes = new ArrayList<Vertex>(graph.getVertexes());
		this.edges = new ArrayList<Edge>(graph.getEdges());
	}

	public void execute(Vertex source) {

		settledNodes = new HashSet<Vertex>();
		unSettledNodes = new HashSet<Vertex>();
		distanceMap = new HashMap<Vertex, Integer>();
		predecessors = new HashMap<Vertex, Vertex>();

		distanceMap.put(source, 0);
		unSettledNodes.add(source);

		while (unSettledNodes.size() > 0) {
			Vertex node = getMinimum(unSettledNodes);
			settledNodes.add(node);
			unSettledNodes.remove(node);
			findMinimalDistances(node);
		}

	}

	private Vertex getMinimum(Set<Vertex> vertexes) {
		Vertex minimum = null;
		for (Vertex vertex : vertexes) {
			if (minimum == null) {
				minimum = vertex;
			} else {
				if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
					minimum = vertex;
				}
			}
		}
		return minimum;
	}

	private int getShortestDistance(Vertex destination) {
		Integer d = distanceMap.get(destination);
		if (d == null) {
			return Integer.MAX_VALUE;
		} else {
			return d;
		}
	}

	private void findMinimalDistances(Vertex node) {
		List<Vertex> adjacentNodes = getNeighbors(node);
		for (Vertex target : adjacentNodes) {
			if (getShortestDistance(target) > getShortestDistance(node)	+ getDistance(node, target)) {
				distanceMap.put(target, getShortestDistance(node)+ getDistance(node, target));
				predecessors.put(target, node);
				unSettledNodes.add(target);
			}
		}
	}

	private int getDistance(Vertex node, Vertex target) {
		for (Edge edge : edges) {
			if (edge.getSource().equals(node) && edge.getDestination().equals(target)) {
				return edge.getWeight();
			}
		}
		throw new RuntimeException("Should not happen");
	}

	private List<Vertex> getNeighbors(Vertex node) {

		List<Vertex> neighbors = new ArrayList<Vertex>();
		for (Edge edge : edges) {
			if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) {
				neighbors.add(edge.getDestination());
			}
		}
		return neighbors;
	}

	private boolean isSettled(Vertex vertex) {
		return settledNodes.contains(vertex);
	}
}
