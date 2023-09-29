package images;

public abstract class BaseImage implements Image {
    private int width;  // Width of the image
    private int height; // Height of the image
    
    public BaseImage(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public int getWidth() {
        return width;
    }
    
    @Override
    public int getHeight() {
        return height;
    }
    
    // The get(int x, int y) method is the strategy function
    // that each image will implement based on its own logic.
    // It retrieves the color of the pixel at the specified (x, y) position.
    // This method is left unimplemented in this abstract class, as it
    // requires specific implementation by the image subclasses.
}
