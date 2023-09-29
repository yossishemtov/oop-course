package images;

public class Gradient extends BaseImage {
    private RGB startColor; // Start color of the gradient
    private RGB endColor; // End color of the gradient
    
    public Gradient(int width, int height, RGB startColor, RGB endColor) {
        super(width, height); // Assign width and height using the super constructor
        this.startColor = startColor; // Assign the start and end colors
        this.endColor = endColor;
    }

    @Override
    public RGB get(int x, int y) {
        // Calculate the mixing ratio based on the x-coordinate
        double mixRatio = 1 - ((double) x / (getWidth()));
        
        // Interpolate between the start and end colors based on the mixing ratio
        RGB interpolatedColor = RGB.mix(startColor, endColor, mixRatio);
        
        return interpolatedColor;
    }
}
