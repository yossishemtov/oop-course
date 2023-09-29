package mines;

import javafx.scene.control.Button;

public class FieldButtons extends Button{
	private int x, y;

	public FieldButtons(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
