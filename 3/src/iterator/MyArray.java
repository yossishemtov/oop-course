package iterator;
import java.util.NoSuchElementException;

public class MyArray implements MyIterator {
	private int length = 0;
	private int sum = 0;
	private int[] a;
	
	
	public MyArray(int[] a) {
		this.length = a.length;
		this.a = a;
	}

	@Override
	public boolean hasNext() {
		// Check if there are more elements in the array to iterate over
		if (sum < length)
			return true;
		return false;
	}

	@Override
	public int next() {
		if (!(hasNext())) {
			// Throw an exception if there are no more elements to iterate over
			throw new NoSuchElementException();
		}
		// Return the next element in the array and increment the sum
		return a[sum++];
	}
	

}