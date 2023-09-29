package images;

public class Circle extends BaseImage {
    private RGB center; // Color of the circle center
    private RGB outside; // Color of the circle outside
    private int centerX; // X-coordinate of the circle center
    private int centerY; // Y-coordinate of the circle center
    private int radius; // Radius of the circle
    
    public Circle(int width, int height, int centerX, int centerY, int radius, RGB center, RGB outside) {
        super(width, height);
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.center = center;
        this.outside = outside;
    }
    
    public Circle(int size, int radius, RGB center, RGB outside) {
        this(size, size, size / 2, size / 2, radius, center, outside);
    }
    
    @Override
    public RGB get(int x, int y) {
        // Calculate the distance from the center of the circle to the current pixel
        double distance = Math.sqrt(Math.pow((double) (centerX - x), 2) + Math.pow((double) (centerY - y), 2));
        
        // Calculate the ratio of the distance to the radius
        double ratio = distance / radius;
        
        // Ensure that the ratio is within the range of 0 to 1
        ratio = Math.min(Math.max(ratio, 0), 1);
        
        // Mix the outside and center colors based on the ratio
        return RGB.mix(outside, center, ratio);
    }
}
