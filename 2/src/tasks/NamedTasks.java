package tasks;

import java.util.Arrays;

public class NamedTasks extends Tasks {
	private String[] names;

	public NamedTasks(String[] names) {
		super(names.length);
		this.names = names;
	}

	/**
	 * Adds a dependency between two tasks represented by their names.
	 * 
	 * task1 the name of the task that must be executed after task2 task2 the name
	 * of the task that must be executed before task1 return true if the dependency
	 * was successfully added, false otherwise
	 */
	public boolean dependsOn(String task1, String task2) {
		int index1 = Arrays.asList(names).indexOf(task1);
		int index2 = Arrays.asList(names).indexOf(task2);
		return super.dependsOn(index1, index2);
	}

	/**
	 * Returns an array of task names in an order that fulfills all the dependencies
	 * in the system.
	 * 
	 * return an array of task names in an order that fulfills all the dependencies,
	 * or null if there is a circular dependency
	 */
	public String[] nameOrder() {
		int[] order = super.order();
		if (order == null) {
			return null;
		}
		String[] nameOrder = new String[order.length];
		for (int i = 0; i < order.length; i++) {
			nameOrder[i] = names[order[i]];
		}
		return nameOrder;
	}
}
