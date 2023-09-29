package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*Graph class - describes a graph that each vertex is type of V (V can be any type).*/
public class Graph<V> {
	private Set<V> vertices = new HashSet<>();
	private Map<V, Set<V>> edges = new HashMap<>();
	
	/*addVertex - will add the vertex if is not in vertices HashSet.
	 * if the given v is in vertices HashSet - it will return GraphException.*/
	public void addVertex(V v) throws GraphException {
		if(vertices.contains(v))
			throw new GraphException("The vertex is already exists!");
		vertices.add(v);
		edges.put(v, new HashSet<>()); //create new hash set for the node
	}
	
	/*addEdge - will add an arc to the v1 and v2 that given (vertices).
	 * if the arc is alreay exsits or one of the vertices are not exsits - the function will return GraphException.*/
	public void addEdge(V v1, V v2) throws GraphException {
		if(!vertices.contains(v1) || !vertices.contains(v2))
			throw new GraphException("One of the nodes is not exists!");
		else if(edges.get(v1).contains(v2) || edges.get(v2).contains(v1))
			throw new GraphException("The arc already exists between the two nodes");
		edges.get(v1).add(v2);
		edges.get(v2).add(v1);
	}
	/*hasEdge - is there is an arc between v1 and v2 (vertices).
	 * if there is an arc - will return true.
	 * else - reutrn false.*/
	public boolean hasEdge(V v1, V v2) {
		if(edges.get(v1).contains(v2) || edges.get(v2).contains(v1))
			return true;
		return false;
	}
	
	/*connected - will return true if we can reach to vertex v1 to vertex v2.
	 * to check if we can reach v1 to v2, we will use basic dfs algorithm.
	 * if one of the vertices are not contains in vertices HashSet - we will return GraphException.*/
	public boolean connected(V v1, V v2) throws GraphException {
		Set<V> visited = new HashSet<>();
		if(!vertices.contains(v1) || !vertices.contains(v2))
			throw new GraphException("One of the nodes is not exists!");
		return dfs(v1, v2, visited);
	}
	
	/*dfs - algorithm of graph. we will add each visited to the visited HashSet(so we can check each node not twice).
	 * with dfs, we will check if we can reach v1 to v2.*/
	private boolean dfs(V v1, V v2, Set<V> visited) {
		visited.add(v1);
		if(v1.equals(v2))
			return true;
		for(V currentNode : edges.get(v1)) {
			if(!visited.contains(currentNode))
				if(dfs(currentNode, v2, visited))
					return true;
		}
		return false;
	}
}
