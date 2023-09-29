package game;

public class Player {
	private String name = null;
	private char mark;

	public Player(String name, char mark) {
		this.mark = mark;
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public char getMark() {
		return mark;
	}

	public String toString() {
		return String.format("%s(%c)", name, mark);
	}

}
