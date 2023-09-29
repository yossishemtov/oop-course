package images;

public abstract class BinaryImageDecorator implements Image {
    protected Image base1; // First base image
    protected Image base2; // Second base image
    
    public BinaryImageDecorator(Image base1, Image base2) {
        this.base1 = base1;
        this.base2 = base2;
    }
    
    @Override
    public int getWidth() {
        // Determine the width of the resulting image
        if (base1.getWidth() > base2.getWidth()) {
            return base1.getWidth(); // Return the width of the larger base image
        } else {
            return base2.getWidth(); // Return the width of the larger base image
        }
    }
    
    @Override
    public int getHeight() {
        // Determine the height of the resulting image
        if (base1.getHeight() > base2.getHeight()) {
            return base1.getHeight(); // Return the height of the larger base image
        } else {
            return base2.getHeight(); // Return the height of the larger base image
        }
    }
    
    // The get(int x, int y) method will be implemented in the subclasses.
    // It retrieves the color of the pixel at the specified (x, y) position
    // based on the specific logic of the decorator subclass.
}
