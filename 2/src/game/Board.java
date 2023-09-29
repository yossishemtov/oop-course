package game;

public class Board {
	protected Player[][] board;
	protected int n, m;
	private int full = 0;

	public Board(int n, int m) {
		board = new Player[n][m];
		this.n = n;
		this.m = m;
	}

	protected boolean set(int i, int j, Player p) {
		if (isEmpty(i, j) == false) // if [i][j] out of boundaries or [i][j] is not empty
			return false;
		board[i][j] = p;
		full++;
		return true;
	}

	public boolean isEmpty(int i, int j) {
		// Checking with indexes in bounds and if the location is empty
		if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] != null) // check if given i,j is incorrect
			return false;
		else
			return true;

	}

	public Player get(int i, int j) {
		return board[i][j];
	}

	public boolean isFull() {
		/*
		 * Checks if the variable full is equal
		 *  to the board size, if so we will 
		 *  return true otherwise false
		 */
		if (full == n * m)
			return true;
		else
			return false;
	}

	public String toString() {
		/*
		 * Move over the board if the position is empty we will enter point else
		 * player mark
		 */
		String res = "";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == null)
					res = res + ".";
				else
					res = String.format("%s%c", res, board[i][j].getMark());
			}
			res = res + "\n";
		}
		return res;
	}

	protected int maxLineContaining(int i, int j) {
		// Initialized to 1 because the given point is not checked
		int countline = 1, countlinemax = 1;
		char mark = board[i][j].getMark();
		// run on line right
		for (int k = j + 1; k < m; k++) {
			if (isEmpty(i, k))
				break;
			if (board[i][k].getMark() == mark) {
				countline++;

			}

		}
		// run on line left
		for (int k = j - 1; k >= 0; k--) {
			if (isEmpty(i, k))
				break;
			if (board[i][k].getMark() == mark) {
				countline++;

			}
		}
		//Checking if greater than the maximum replace them
		check(countline,countlinemax);
		countline = 1;
		// run on col up
		for (int k = i + 1; k < n; k++) {
			if (isEmpty(k, j))
				break;
			if (board[k][j].getMark() == mark) {
				countline++;

			}
		}
		// run on col down
		for (int k = i - 1; k >= 0; k--) {
			if (isEmpty(k, j))
				break;
			if (board[k][j].getMark() == mark) {
				countline++;

			}
		}
		if (countline > countlinemax)
			countlinemax = countline;
		countline = 1;

		// run on diagonal to the right and down
		int k = i + 1, l = j + 1;
		while (true) {

			if (isEmpty(k, l) || k >= n || l >= m)
				break;
			if (board[k][l].getMark() == mark) {
				countline++;
			}
			k++;
			l++;
		}
		// run on diagonal to the left and up

		k = i - 1;
		l = j - 1;
		while (true) {
			if (isEmpty(k, l) || k < 0 || l < 0)
				break;
			if (board[k][l].getMark() == mark) {
				countline++;

			}
			k--;
			l--;
		}
		if (countline > countlinemax)
			countlinemax = countline;

		countline = 1;

		// run on diagonal to the right and up
		k = i + 1;
		l = j - 1;
		while (true) {

			if (isEmpty(k, l) || k >= n || l < 0)
				break;
			if (board[k][l].getMark() == mark) {
				countline++;

			}
			k++;
			l--;
		}
		// run on diagonal to the left and down

		k = i - 1;
		l = j + 1;
		while (true) {

			if (isEmpty(k, l) || k < 0 || l >= m)
				break;
			if (board[k][l].getMark() == mark) {
				countline++;

			}
			k--;
			l++;
		}
		if (countline > countlinemax)
			countlinemax = countline;

		return countlinemax;

	}
	
	private static void check(int num1,int num2)
	{
		if(num1>num2)
			num2=num1;
	}
}
