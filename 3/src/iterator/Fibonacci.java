package iterator;

public class Fibonacci implements MyIterator {
	private int upperBound;
	private int a1 = 1, a2 = 0, a3 = 0;

	public Fibonacci(int upperBound) {
		this.upperBound = upperBound;
	}

	@Override
	public boolean hasNext() {
		// Check if the sum of the two previous numbers is still below the upper bound
		if (upperBound > a1 + a2)
			return true;
		return false;
	}

	@Override
	public int next() {
		if (hasNext()) {
			// Calculate the next Fibonacci number
			a3 = a1 + a2;
			// Update the previous numbers
			a1 = a2;
			a2 = a3;
			return a3;
		} else {
			// If there are no more Fibonacci numbers below the upper bound, return the last calculated number
			return a3;
		}
	}

}
