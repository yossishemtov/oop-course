package images;

public class Invert extends ImageDecorator {

    public Invert(Image base) {
        super(base);
    }
    
    @Override
    public RGB get(int x, int y) {
        // Get the color at (x, y) from the base image and invert it
        return base.get(x, y).invert(); 
    }
}
