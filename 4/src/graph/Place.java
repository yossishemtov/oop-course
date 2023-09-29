package graph;

/**
 * Place class represents a point in a square grid.
 * The class overrides the hashCode and equals methods to facilitate usage in HashMap and HashSet.
 */
public class Place {
    private int x;
    private int y;

    /**
     * Constructs a Place object with the specified coordinates.
     *
     * @param x      The x-coordinate of the place.
     * @param y      The y-coordinate of the place.
     * @param bound  The bound of the square grid.
     * @throws IllegalArgumentException if the coordinates are out of bounds.
     */
    public Place(int x, int y, int bound) {
        if ((x < 0 || x > bound - 1) || (y < 0 || y > bound - 1))
            throw new IllegalArgumentException("Coordinates out of bounds");
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x-coordinate of the place.
     *
     * @return The x-coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y-coordinate of the place.
     *
     * @return The y-coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Generates a hash code for the Place object.
     *
     * @return The hash code value.
     */
    @Override
    public int hashCode() {
        return (int) Math.pow(x + y, 2) + x;
    }

    /**
     * Checks if the Place object is equal to another object.
     *
     * @param obj The object to compare.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Place))
            return false;
        Place other = (Place) obj;
        return x == other.x && y == other.y;
    }
}
