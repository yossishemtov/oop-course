package game;

public class FourInARow extends Game {

	public FourInARow(String player1, String player2) {
		super(6, 7, new Player(player1, 'W'), new Player(player2, 'B'));
	}

	@Override
	protected boolean doesWin(int i, int j) {
		/*
		 * Checking if the move produces a sequence of size 4 will return true otherwise
		 * false
		 */
		int r = maxLineContaining(i, j);
		if (r == 4)
			return true;
		return false;
	}

	@Override
	protected boolean onePlay(Player p) {
		int c, count = 0;
		String res;
		boolean flag = true;
		res = String.format("%s(%c) enter column: ", p.getName(), p.getMark());
		System.out.println(res);
		c = s.nextInt();
		while (flag) {
			/*
			 * Checking if a column is full 
			 * asks him to select another column
			 */
			for (int i = 0; i < 7; i++) {
				if (isEmpty(i, c) == false) {
					count++;
				}
			}
			if (count == 7) {
				System.out.println("The column is full");
				res = String.format("%s(%c) enter column: ", p.getName(), p.getMark());
				System.out.println(res);
				c = s.nextInt();
				count = 0;
				//Otherwise we will place the player in a slot
			} else {
				set(count, c, p);
				flag = false;
			}

		}
		return doesWin(count, c);

	}
}
