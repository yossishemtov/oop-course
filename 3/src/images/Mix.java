package images;

public class Mix extends BinaryImageDecorator {

    private double alpha;
    
    public Mix(Image base1, Image base2, double alpha) {
        super(base1, base2);
        this.alpha = alpha;
    }
    
    @Override
    public RGB get(int x, int y) {
        // Check if the coordinates (x, y) are within the bounds of both base images
        if (x < base1.getWidth() && x < base2.getWidth() && y < base1.getHeight() && y < base2.getHeight()) {
            // Retrieve the colors from base1 and base2 at (x, y)
            RGB color1 = base1.get(x, y);
            RGB color2 = base2.get(x, y);
            // Mix the colors using the given alpha value
            return RGB.mix(color1, color2, alpha);
        } else if (x < base1.getWidth() && y < base1.getHeight()) {
            // If the coordinates are within the bounds of base1 only, return the color from base1
            return base1.get(x, y);
        } else if (x < base2.getWidth() && y < base2.getHeight()) {
            // If the coordinates are within the bounds of base2 only, return the color from base2
            return base2.get(x, y);
        } else {
            // If the coordinates are undefined in both images, return black color
            return RGB.BLACK;
        }
    }
}
