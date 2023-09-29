package root;

public class Rooter {
	private double precision;
	
	public Rooter(double precision) {
		this.precision=precision;
	}
	
	public void setPrecision(double precision) {
		this.precision=precision;
		
	}
	
	// Calculates the square root of x. the answer accurate to the point of precision
	public double sqrt(double x) {
		double one=x/2;
		boolean flag =true;
		while(flag) {
			double two=x/one;
			if (one==two)
			{
				return one;
			}
			if(Math.abs(one-two)<precision)
			{
				return one;
			}
			else
			{
				one=(one+two)/2;
			}
		}
		return one;
		
	}

}

