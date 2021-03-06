package graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Name - Race Saunders
 * Directory ID - rssaunde
 * University ID - 114803078
 * Section - 0108
 * "I pledge on my honor that I have not given or received any unauthorized assistance on this assignment."
 *  
 *  The purpose of this class is to implement a weighted, directed graph.
 */
public class Graph<V> {
	private HashMap<V, HashMap<V, Integer>> graph = new HashMap<V, HashMap<V, Integer>>();

	public boolean addVertex(V vertexToAdd) {
		// checks for null parameters
		if (vertexToAdd == null) {
			throw new IllegalArgumentException();
		}
		// checks to see if the vertex is in the graph
		if (!graph.containsKey(vertexToAdd)) {
			// if not the vertex is added
			HashMap<V, Integer> m = new HashMap<V, Integer>();
			graph.put(vertexToAdd, m);
			return true;
		}
		return false;

	}

	public boolean isVertex(V vertexToCheck) {
		// checks for null parameters
		if (vertexToCheck == null) {
			throw new IllegalArgumentException();
		}
		// checks to see if the vertex is in the graph
		if (graph.containsKey(vertexToCheck)) {
			// returns true if the vertex is in the graph
			return true;
		}
		return false;
	}

	public Collection<V> getVertices() {
		// throw new UnsupportedOperationException("You must write this
		// method.");
		return graph.keySet();
	}

	public boolean removeVertex(V vertexToRemove) {
		// throw new UnsupportedOperationException("You must write this
		// method.");
		// checks for null parameters
		if (vertexToRemove == null) {
			throw new IllegalArgumentException();
		}
		// checks to see if the vertex is in the graph
		if (graph.containsKey(vertexToRemove)) {
			// if so, removes the vertex, and loops through the keyset removing
			// edges that contained the vertex
			graph.remove(vertexToRemove);
			for (V v : graph.keySet()) {
				if (graph.get(v).containsKey(vertexToRemove)) {
					graph.get(v).remove(vertexToRemove);
				}

			}
			// returns true if remove successful
			return true;
		}

		return false;
	}

	public boolean createEdge(V from, V to, int cost) {
		// throw new UnsupportedOperationException("You must write this
		// method.");
		// checks for null parameters
		if (from == null || to == null) {
			throw new IllegalArgumentException();
		}
		// makes sure the cost is within the viable range, and checks if the
		// graph contains the specified edge
		if (cost < 0 || (graph.containsKey(from) && graph.get(from).containsKey(to))) {
			return false;
		}
		// adds the vertex's if they are not present already
		if (!graph.containsKey(from)) {
			addVertex(from);
		}
		if (!graph.containsKey(to)) {
			addVertex(to);
		}
		// adds the edge and returns true
		graph.get(from).put(to, cost);
		return true;
	}

	public int costOfEdge(V from, V to) {
		// throw new UnsupportedOperationException("You must write this
		// method.");
		// checks for null parameters
		if (from == null || to == null) {
			throw new IllegalArgumentException();
		}
		// returns the cost of the edge, if it exists, -1 otherwise
		if (graph.containsKey(from)) {
			if (graph.get(from).containsKey(to)) {
				return graph.get(from).get(to);
			}
		}
		return -1;
	}

	public boolean changeEdgeCost(V from, V to, int newCost) {
		// throw new UnsupportedOperationException("You must write this
		// method.");
		// checks for null parameters
		if (from == null || to == null) {
			throw new IllegalArgumentException();
		}
		// makes sure cost is within the viable bound
		if (newCost < 0) {
			return false;
		}
		// if the edge exists, the cost is changed, false is returned otherwise
		if (graph.containsKey(from)) {
			if (graph.get(from).containsKey(to)) {
				graph.get(from).put(to, newCost);
				return true;
			}
		}
		return false;
	}

	public boolean removeEdge(V from, V to) {
		// throw new UnsupportedOperationException("You must write this
		// method.");
		//checks for null parameters
		if (from == null || to == null) {
			throw new IllegalArgumentException();
		}
		//if the edge exists, it is removed, false is returned otherwise
		if (graph.containsKey(from)) {
			if (graph.get(from).containsKey(to)) {
				graph.get(from).remove(to);
				return true;
			}
		}
		return false;
	}

	public Collection<V> neighborsOfVertex(V sourceVertex) {
		// throw new UnsupportedOperationException("You must write this
		// method.");
		//checks for null parameters
		if (sourceVertex == null) {
			throw new IllegalArgumentException();
		}
		//if the graph contains the vertex, then returns the keyset for that vertex
		if (graph.containsKey(sourceVertex)) {
			return graph.get(sourceVertex).keySet();
		}
		//returns an empty set otherwise
		return new HashSet<V>();
	}

	public Collection<V> reachable(V from) {
		// throw new UnsupportedOperationException("You must write this
		// method.");
		//checks for null parameters
		if (from == null) {
			throw new IllegalArgumentException();
		}
		//recursively adds vertices and then returns the set
		Collection<V> n = new HashSet<V>();
		n.add(from);
		for (V v : neighborsOfVertex(from)) {
			n.addAll(reachable(v));
		}
		return n;
	}

	public Graph<V> divideGraph(Collection<V> verticesForNewGraph) {
		// throw new UnsupportedOperationException("You must write this
		// method.");
		
		Graph<V> graph2 = new Graph<V>();
		for (V v : verticesForNewGraph) {
			if (graph.containsKey(v)) {
				graph2.addVertex(v);
				for (V v2 : verticesForNewGraph) {
					if(graph.get(v).containsKey(v2))
					{
						graph2.createEdge(v, v2, costOfEdge(v, v2));
					}
				}
				graph.remove(v);
			}

		}
		return graph2;
	}

}
