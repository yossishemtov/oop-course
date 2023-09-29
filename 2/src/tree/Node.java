package tree;

public class Node {
	private int count = 0;
	private Node[] children = new Node['z' - 'a' + 1];

	public int num(String s) {
		int index = s.charAt(0) - 'a';
		Node child = children[index];
		if (s.length() == 0) {
			// if the input string is empty, return the count of the current node
			return count;
		}
		if (child == null) {
			// if the child corresponding to the first character does not exist, the string
			// is not in the tree
			return 0;
		}
		if (s.length() == 1) {
			// if we've reached the end of the string, return the count of the current child
			// node
			return child.count;
		}
		return child.num(s.substring(1)); // recursively count the number of occurrences of the rest of the string
	}

	public void add(String s) {
		int index = s.charAt(0) - 'a';
		Node child = children[index];
		// If the string is empty, we don't need to add anything
		if (s.isEmpty())
			return;

		// If a child node doesn't exist at the computed index, create a new one
		if (child == null) {
			child = new Node();
			children[index] = child;
		}

		// If we've reached the end of the string, increment the count field
		// of the current node to indicate that the string has been added
		if (s.length() == 1) {
			child.count++;
		}
		// Otherwise, recursively add the remaining substring of s
		// starting at the child node we just created
		else {
			child.add(s.substring(1));
		}
	}
}
