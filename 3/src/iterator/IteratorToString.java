package iterator;

public class IteratorToString {
	
	public static String toString(MyIterator it) {
		int s = 0;
		StringBuilder b = new StringBuilder();
		b.append("[");
		while (it.hasNext()) {
			// Append the next element of the iterator to the string builder
			b.append(it.next() + " ");
		}
		s = b.length() - 1;
		b.deleteCharAt(s);
		b.append("]");
		
		return b.toString();
	}

}
