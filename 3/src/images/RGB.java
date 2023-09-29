package images;

public class RGB 
{
	private double red, green, blue;
	
	/**
	 * Constructs an RGB color with the specified red, green, and blue values.
	 * The values are clamped between 0 and 1 to ensure valid color components.
	 */
	public RGB(double red, double green, double blue)
	{
		this.red = Math.max(0, Math.min(1, red));
		this.green = Math.max(0, Math.min(1, green));
		this.blue = Math.max(0, Math.min(1, blue));
	}
	
	public RGB(double grey) {
		this(grey, grey, grey);
	}
	
	public double getRed() {
		return red;
	}
	
	public double getGreen() {
		return green;
	}
	
	public double getBlue() {
		return blue;
	}
	
	/**
	 * Returns the inverted RGB color, which is obtained by subtracting each
	 * component from 1.0.
	 */
	public RGB invert() {
		return new RGB(1 - red, 1 - green, 1 - blue);
	}
	
	/**
	 * Returns the inverted RGB color, which is obtained by subtracting each
	 * component from 1.0.
	 */
	public RGB filter(RGB filter) {
		return new RGB(red * filter.getRed(), green * filter.getGreen(), blue * filter.getBlue());
	}
	
	/**
	 * Returns the superposition of two RGB colors, obtained by adding the
	 * corresponding components of the colors.
	 */
	public static RGB superpose(RGB rgb1, RGB rgb2) {
		return new RGB(rgb1.getRed() + rgb2.getRed(), rgb1.getGreen() + rgb2.getGreen(), rgb1.getBlue() + rgb2.getBlue());
	}
	
	/**
	 * Returns a new RGB color that is a mixture of two colors based on the given
	 * alpha value. The alpha value determines the weight of each color in the mixture.
	 */
	public static RGB mix(RGB rgb1, RGB rgb2, double alpha) {
		double inverseAlpha = 1 - alpha;
		double red = alpha * rgb1.getRed() + inverseAlpha * rgb2.getRed();
		double green = alpha * rgb1.getGreen() + inverseAlpha * rgb2.getGreen();
		double blue = alpha * rgb1.getBlue() + inverseAlpha * rgb2.getBlue();
		return new RGB(red, green, blue);
	}
	
	@Override
	public String toString() {
		return String.format("<%.4f, %.4f, %.4f>", red, green, blue);
	}
	
	public static final RGB BLACK = new RGB(0);
	public static final RGB WHITE = new RGB(1);
	public static final RGB RED = new RGB(1, 0, 0);
	public static final RGB GREEN = new RGB(0, 1, 0);
	public static final RGB BLUE = new RGB(0, 0, 1);
}
