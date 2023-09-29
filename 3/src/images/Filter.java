package images;

public class Filter extends ImageDecorator {
    private RGB filterColor; // Color of the filter
    
    public Filter(Image base, RGB filterColor) {
        super(base); // Use the super constructor to assign the base Image
        this.filterColor = filterColor;
    }
    
    @Override
    public RGB get(int x, int y) {
        // Retrieve the color of the pixel at (x, y) from the base Image
        RGB baseColor = base.get(x, y);
        
        // Apply the filter color to the base color using the filter() method
        RGB filteredColor = baseColor.filter(filterColor);
        
        return filteredColor; // Return the filtered color
    }
}
