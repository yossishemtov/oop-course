package images;

public abstract class ImageDecorator implements Image {
    protected Image base; // The base image to be decorated
    
    // Constructor to assign the base image (according to the Decorator design pattern)
    ImageDecorator(Image base) {
        this.base = base;
    }
    
    @Override
    public int getWidth() {
        return base.getWidth(); // Delegate the getWidth() method to the base image
    }
    
    @Override
    public int getHeight() {
        return base.getHeight(); // Delegate the getHeight() method to the base image
    }
    // The get(int x, int y) method will be implemented by each subclass using the base image field as the base image.
}
