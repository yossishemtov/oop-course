package graph;

import java.util.Collection;

/**
 * GraphInterface represents an interface for a graph data structure.
 *
 * @param <V> The type of vertices in the graph.
 */
public interface GraphInterface<V> {

    /**
     * Returns the neighboring vertices of a given vertex in the graph.
     *
     * @param v The vertex to find neighbors for.
     * @return A collection of neighboring vertices.
     */
    public Collection<V> neighbours(V v);
}
