package graph;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Maze class describes a maze with a starting point and an ending point.
 * The maze can be solvable or not. Walls are represented by null values in the mazeArray.
 */
public class Maze implements GraphInterface<Place> {
    private Place mazeArray[][];
    private Place startPoint, endPoint;

    /**
     * Constructs a Maze object with the specified size and coordinates for the starting and ending points.
     *
     * @param size    The size of the maze.
     * @param startx  The x-coordinate of the starting point.
     * @param starty  The y-coordinate of the starting point.
     * @param endx    The x-coordinate of the ending point.
     * @param endy    The y-coordinate of the ending point.
     */
    public Maze(int size, int startx, int starty, int endx, int endy) {
        mazeArray = new Place[size][size];
        initMaze(size);
        this.startPoint = mazeArray[startx][starty];
        this.endPoint = mazeArray[endx][endy];
    }

    /**
     * Initializes the mazeArray with each place for each index.
     *
     * @param size The size of the maze.
     */
    private void initMaze(int size) {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                mazeArray[i][j] = new Place(i, j, size);
    }

    /**
     * Adds a wall in the mazeArray.
     * If the wall already exists or the given point is out of bounds or overlaps with the starting or ending point,
     * the function returns false. Otherwise, it adds the wall and returns true.
     *
     * @param x The x-coordinate of the wall.
     * @param y The y-coordinate of the wall.
     * @return true if the wall is added successfully, false otherwise.
     */
    public boolean addWall(int x, int y) {
        Place checkWall = new Place(x, y, mazeArray.length);
        if (isWall(mazeArray[x][y]) || checkWall.equals(startPoint) || checkWall.equals(endPoint))
            return false;
        mazeArray[x][y] = null;
        return true;
    }

    /**
     * Checks if the maze is solvable.
     * It creates a mazeGraph using the Graph generic class, adds vertices and edges, and checks if there is a path
     * from the starting point to the ending point using the connected method. If connected, it returns true; otherwise, false.
     *
     * @return true if the maze is solvable, false otherwise.
     */
    public boolean isSolvable() {
        Graph<Place> mazeGraph = new Graph<>();
        addMazeVertex(mazeGraph);
        addMazeEdges(mazeGraph);
        try {
            if (mazeGraph.connected(startPoint, endPoint))
                return true;
        } catch (GraphException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Adds each vertex to the mazeGraph from the mazeArray if it is not a wall.
     *
     * @param mazeGraph The maze graph to add the vertices to.
     */
    private void addMazeVertex(Graph<Place> mazeGraph) {
        for (int i = 0; i < mazeArray.length; i++)
            for (int j = 0; j < mazeArray.length; j++)
                if (!isWall(mazeArray[i][j])) {
                    try {
                        mazeGraph.addVertex(mazeArray[i][j]);
                    } catch (GraphException e) {
                        e.printStackTrace();
                    }
                }
    }

    /**
     * Adds edges to the mazeGraph by iterating over each index in the mazeArray.
     *
     * @param mazeGraph The maze graph to add the edges to.
     */
    private void addMazeEdges(Graph<Place> mazeGraph) {
        for (int i = 0; i < mazeArray.length; i++)
            for (int j = 0; j < mazeArray.length; j++)
                if (!isWall(mazeArray[i][j])) {
                    if (i < mazeArray.length - 1 && !isWall(mazeArray[i + 1][j])) {
                        try {
                            mazeGraph.addEdge(mazeArray[i][j], mazeArray[i + 1][j]);
                        } catch (GraphException e) {
                            e.printStackTrace();
                        }
                    }
                    if (j < mazeArray.length - 1 && !isWall(mazeArray[i][j + 1])) {
                        try {
                            mazeGraph.addEdge(mazeArray[i][j], mazeArray[i][j + 1]);
                        } catch (GraphException e) {
                            e.printStackTrace();
                        }
                    }
                }
    }

    /**
     * Checks if the given place in the mazeArray is a wall.
     *
     * @param mazeIndex The place to check.
     * @return true if the place is a wall, false otherwise.
     */
    private boolean isWall(Place mazeIndex) {
        return mazeIndex == null;
    }

    /**
     * Returns the neighboring places of the given place.
     *
     * @param p The place to find neighbors for.
     * @return A collection of neighboring places.
     */
    @Override
    public Collection<Place> neighbours(Place p) {
        Collection<Place> neighbours = new ArrayList<>();
        if (p.getX() > 0 && !isWall(mazeArray[p.getX() - 1][p.getY()]))
            neighbours.add(mazeArray[p.getX() - 1][p.getY()]);
        if (p.getY() > 0 && !isWall(mazeArray[p.getX()][p.getY() - 1]))
            neighbours.add(mazeArray[p.getX()][p.getY() - 1]);
        if (p.getX() < mazeArray.length - 1 && !isWall(mazeArray[p.getX() + 1][p.getY()]))
            neighbours.add(mazeArray[p.getX() + 1][p.getY()]);
        if (p.getY() < mazeArray.length - 1 && !isWall(mazeArray[p.getX()][p.getY() + 1]))
            neighbours.add(mazeArray[p.getX()][p.getY() + 1]);
        return neighbours;
    }

    /**
     * Returns a string representation of the maze.
     *
     * @return The string representation of the maze.
     */
    @Override
    public String toString() {
        StringBuilder mazeBuilder = new StringBuilder();
        for (int i = 0; i < mazeArray.length; i++) {
            for (int j = 0; j < mazeArray.length; j++) {
                if (isWall(mazeArray[i][j]))
                    mazeBuilder.append("@");
                else if (!isWall(mazeArray[i][j]) && mazeArray[i][j].equals(startPoint))
                    mazeBuilder.append("S");
                else if (!isWall(mazeArray[i][j]) && mazeArray[i][j].equals(endPoint))
                    mazeBuilder.append("E");
                else
                    mazeBuilder.append(".");
            }
            mazeBuilder.append("\n");
        }
        return mazeBuilder.toString();
    }
}
