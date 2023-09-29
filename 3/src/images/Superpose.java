package images;

public class Superpose extends BinaryImageDecorator {

	public Superpose(Image base1, Image base2) {
		super(base1, base2);
	}

	@Override
	public RGB get(int x, int y) {
	    boolean pointInBase1 = x < base1.getWidth() && y < base1.getHeight();
	    boolean pointInBase2 = x < base2.getWidth() && y < base2.getHeight();

	    if (pointInBase1 && pointInBase2) {
	        return RGB.superpose(base1.get(x, y), base2.get(x, y));
	        // If the point is defined in both base images,
	        // superpose the colors from base1 and base2 and return the result.
	    } else if (pointInBase1) {
	        return base1.get(x, y);
	        // If the point is only defined in base1, return the color from base1.
	    } else if (pointInBase2) {
	        return base2.get(x, y);
	        // If the point is only defined in base2, return the color from base2.
	    } else {
	        return RGB.BLACK;
	        // If the point is undefined in both images, return RGB.BLACK.
	    }
	}

}
