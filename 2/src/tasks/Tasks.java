package tasks;

public class Tasks {
	private int[][] directedGraph;
	private int[] tasksOrder;
	private int curSize;

	// Initializes a Tasks object with a number of tasks.
	public Tasks(int num) {
		directedGraph = new int[num][num];
		tasksOrder = new int[num];
		curSize = num - 1;
	}

	/**
	 * Adds a dependency between two tasks represented by their names.
	 * 
	 * task1 the name of the task that must be executed after task2 task2 the name
	 * of the task that must be executed before task1 return true if the dependency
	 * was successfully added, false otherwise
	 */
	public boolean dependsOn(int task1, int task2) {
		if (task1 < 0 || task1 >= tasksOrder.length || task2 < 0 || task2 >= tasksOrder.length) {
			return false;
		}
		directedGraph[task2][task1] = 1;
		return true;
	}

	/**
	 * Determines the order in which tasks can be executed. return an array
	 * containing the order of tasks, or null if there is a cyclic dependency
	 */
	public int[] order() {
		String[] color = new String[tasksOrder.length];
		for (int i = 0; i < tasksOrder.length; i++) // initialize all edges to be undiscovered.
			color[i] = "WHITE";

		for (int i = 0; i < tasksOrder.length; i++) {
			if (color[i].equals("WHITE")) {
				if (!dfsVisit(i, color)) {
					return null;
				}
			}
		}
		curSize = tasksOrder.length - 1;
		return tasksOrder;
	}

	/**
	 * Helper method for the order method. Uses depth-first search to visit tasks
	 * and check for cyclic dependencies.
	 *
	 * @param task  the index of the task to visit
	 * @param color an array indicating whether a task has been visited and its
	 *              color (WHITE, RED, or BLACK)
	 * @return true if the visit was successful, false otherwise
	 */
	private boolean dfsVisit(int task, String[] color) {
		color[task] = "RED";
		for (int i = 0; i < tasksOrder.length; i++) {
			if (directedGraph[task][i] == 1) {
				if (color[i].equals("WHITE")) {
					if (!dfsVisit(i, color)) {
						return false;
					}
				} else if (color[i].equals("RED")) {
					return false;
				}
			}
		}
		color[task] = "BLACK";
		tasksOrder[curSize] = task;
		curSize--;
		return true;
	}
}