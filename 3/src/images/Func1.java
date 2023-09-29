package images;

public class Func1 implements TwoDFunc {
    @Override
    public double f(double x, double y) {
        if (y < 0.25)
            return 1;
    	
        if (x < 0.25)
            return 0;
        
        return (x + y) / 2;
    }
}
