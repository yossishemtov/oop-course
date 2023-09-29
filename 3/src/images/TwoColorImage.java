package images;

public class TwoColorImage extends BaseImage {
    private TwoDFunc func;
    private RGB zero, one;

    public TwoColorImage(int width, int height, RGB zero, RGB one, TwoDFunc func) {
        super(width, height);
        this.zero = zero; // Save the zero color
        this.one = one; // Save the one color
        this.func = func; // Save the function to determine color values
    }

    @Override
    public RGB get(int x, int y) {
        double normalizedX = (double) x / getWidth(); // Normalize x coordinate to range [0, 1]
        double normalizedY = (double) y / getHeight(); // Normalize y coordinate to range [0, 1]
        double alpha = func.f(normalizedX, normalizedY); // Calculate alpha value using the given function

        if (alpha <= 0) {
            return zero; // If alpha is less than or equal to 0, return the zero color
        } else if (alpha >= 1) {
            return one; // If alpha is greater than or equal to 1, return the one color
        } else {
            return RGB.mix(one, zero, alpha); // Mix the colors based on alpha value and return the result
        }
    }

}
