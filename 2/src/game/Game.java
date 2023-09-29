package game;

import java.util.Scanner;

public class Game extends Board {
	protected Player[] players;
	protected Scanner s = new Scanner(System.in);

	public Game(int n, int m, Player p1, Player p2) {
		super(n, m);
		this.players = new Player[2];
		this.players[0] = p1;
		this.players[1] = p2;
		this.n = n;
		this.m = m;

	}

	protected boolean doesWin(int i, int j) {
		if (i == 0 && j == 0)
			return true;
		return false;
	}

	protected boolean onePlay(Player p) {
		int k, l;
		String res;

		res = String.format("%s(%c) enter your move i,j: ", p.getName(), p.getMark());
		System.out.print(res);
		k = s.nextInt();
		l = s.nextInt();
		/*
		 * We will ask for a new input as 
		 * long as the point is occupied or not 
		 * within the boundaries of the board
		 */
		while (set(k, l, p) != true) {
			System.out.println();
			System.out.println("The point is not available");
			res = String.format("%s(%c) enter your move i,j: ", p.getName(), p.getMark());
			System.out.print(res);
			k = s.nextInt();
			l = s.nextInt();
		}
		System.out.println();
		System.out.println(toString());
		/*
		 * Returning a value using 
		 *  doesWin if a winning move is true 
		 *  otherwise false
		 */
		return doesWin(k, l);
	}

	public Player play() {
		String res;
		/*
		 * Each player will play in turn until 
		 * someone wins or the board is full
		 */
		while (!isFull()) {
			if (onePlay(this.players[0])) {
				res = String.format("%s(%c) is the winnerr!! ", this.players[0].getName(), this.players[0].getMark());
				System.out.println(res);
				return this.players[0];
			}
			if (onePlay(this.players[1])) {
				res = String.format("%s(%c) is the winnerr!! ", this.players[1].getName(), this.players[1].getMark());
				System.out.println(res);
				return this.players[1];

			}
		}
		return null;

	}

}
