package graph;

import java.util.HashSet;
import java.util.Set;

/**
 * ConnectionChecker is a class that checks if two vertices are connected in a graph.
 *
 * @param <V> The type of vertices in the graph.
 */
public class ConnectionChecker<V> {
    private GraphInterface<V> graph;

    /**
     * Constructs a ConnectionChecker with the given graph.
     *
     * @param graph The graph to perform the connectivity checks on.
     */
    public ConnectionChecker(GraphInterface<V> graph) {
        this.graph = graph;
    }

    /**
     * Checks if there is a path between two vertices in the graph.
     *
     * @param v1 The starting vertex.
     * @param v2 The ending vertex.
     * @return true if there is a path between v1 and v2, false otherwise.
     */
    public boolean check(V v1, V v2) {
        Set<V> visited = new HashSet<>();
        return depthFirstSearch(v1, v2, visited);
    }

    /**
     * Performs a depth-first search to check if there is a path between two vertices.
     *
     * @param currentVertex The current vertex being visited.
     * @param targetVertex  The target vertex to reach.
     * @param visited       A set of visited vertices to avoid cycles.
     * @return true if there is a path between the currentVertex and targetVertex, false otherwise.
     */
    private boolean depthFirstSearch(V currentVertex, V targetVertex, Set<V> visited) {
        visited.add(currentVertex);
        if (currentVertex.equals(targetVertex))
            return true;
        for (V neighbor : graph.neighbours(currentVertex)) {
            if (!visited.contains(neighbor)) {
                if (depthFirstSearch(neighbor, targetVertex, visited))
                    return true;
            }
        }
        return false;
    }
}
