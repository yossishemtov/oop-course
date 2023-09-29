package images;

public class Transpose extends BaseImage {

	private Image base;

	// Constructor
	Transpose(Image base) {
		super(base.getHeight(), base.getWidth()); // Set the width and height of the transposed image
		this.base = base; // Save the original image
	}

	@Override
	public RGB get(int x, int y) {
		return base.get(y, x);
		// Use the get method of the original image and swap the x and y coordinates
		// to retrieve the color from the transposed position
	}
}
