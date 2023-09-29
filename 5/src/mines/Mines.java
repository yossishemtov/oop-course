package mines;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mines {
	private int height, width;
	private int numMines;
	private Field[][] field;
	private List<Loaction> visitedLoactions = new ArrayList<>();
	private boolean showAll;
	
	public Mines(int height, int width, int numMines) {
		this.height = height;
		this.width = width;
		field = new Field[height][width];
		this.numMines = numMines;
		initField(); // Initialize the field
		initMinesInField(); // Initialize mines in the field
	}
	
	// Initialize mines in the field
	private void initMinesInField() {
		Random minesRandomize = new Random();
		int i, j;
		for(int mineCounter = 0; mineCounter < numMines; mineCounter++) {
			i = minesRandomize.nextInt(height);
			j = minesRandomize.nextInt(width);
			while(field[i][j].isMine) {
				i = minesRandomize.nextInt(height);
				j = minesRandomize.nextInt(width);
			}
			field[i][j].isMine = true;
			updateNeighboursMine(i, j); // Update neighbor mine count
		}
	}
	
	// Initialize the field
	private void initField() {
		for(int i=0; i<height; i++)
			for(int j=0; j<width; j++)
				field[i][j] = new Field();
	}
	
	// Add a mine at a specific location
	public boolean addMine(int i, int j) {
		if(field[i][j].isMine)
			throw new IllegalArgumentException();
		if (i >= height || j >= width)
			throw new IndexOutOfBoundsException();
		field[i][j].isMine = true;;
		numMines++;
		updateNeighboursMine(i, j); // Update neighbor mine count
		return true;
	}
	
	// Open a field at a specific location
	public boolean open(int i, int j) {
		if (i >= height || j >= width)
			throw new IndexOutOfBoundsException();
		
		if(field[i][j].isOpen)
			return true;
		
		if(field[i][j].isMine) {
			field[i][j].isOpen = true;
			return false;
		}
		
		if(!field[i][j].isMine && field[i][j].numOfMines!=0) {
			field[i][j].isOpen = true;
			return true;
		}
		
		if(field[i][j].numOfMines==0)
			field[i][j].isOpen = true;
		
		visitedLoactions.add(new Loaction(i, j));
		if (i - 1 >= 0 && j - 1 >= 0 && !field[i - 1][j - 1].isMine) 
			if (!visitedLoactions.contains(new Loaction(i - 1, j - 1)))
				open(i - 1, j - 1);
		if (i - 1 >= 0 && !field[i - 1][j].isMine)
			if (!visitedLoactions.contains(new Loaction(i - 1, j)))
				open(i - 1, j);
		if (i - 1 >= 0 && j + 1 < width && !field[i - 1][j + 1].isMine)
			if (!visitedLoactions.contains(new Loaction(i - 1, j + 1)))
				open(i - 1, j + 1);

		if (j - 1 >= 0 && !field[i][j - 1].isMine)
			if (!visitedLoactions.contains(new Loaction(i, j - 1)))
				open(i, j - 1);
		if (j + 1 < width && !field[i][j + 1].isMine)
			if (!visitedLoactions.contains(new Loaction(i, j + 1)))
				open(i, j + 1);

		if (i + 1 < height && j - 1 >= 0 && !field[i + 1][j - 1].isMine)
			if (!visitedLoactions.contains(new Loaction(i + 1, j - 1)))
				open(i + 1, j - 1);
		if (i + 1 < height && !field[i + 1][j].isMine)
			if (!visitedLoactions.contains(new Loaction(i + 1, j)))
				open(i + 1, j);
		if (i + 1 < height && j + 1 < width && !field[i + 1][j + 1].isMine)
			if (!visitedLoactions.contains(new Loaction(i + 1, j + 1)))
				open(i + 1, j + 1);
		return true;
	}

	// Toggle flag at a specific location
	public void toggleFlag(int x, int y) {
		if (x >= height || y >= width)
			throw new IndexOutOfBoundsException();
		
		if(!field[x][y].isOpen && !field[x][y].isFlag)
			field[x][y].isFlag = true;
		else if(field[x][y].isFlag)
			field[x][y].isFlag = false;
	}
	
	// Check if the game is finished
	public boolean isDone() {
		int closedMines=0, openFields=0;
		for(int i=0; i<height; i++)
			for(int j=0; j<width; j++) {
				if(!field[i][j].isOpen && field[i][j].isMine)
					closedMines++;
				if(field[i][j].isOpen)
					openFields++;
			}
		if(closedMines == numMines && openFields == ((height * width) - numMines))
			return true;
		return false;
	}
	
	// Get the symbol for a specific field location
	public String get(int i, int j) {
		if(field[i][j].isFlag && !showAll)
			return "F";
		if((!field[i][j].isOpen && !showAll) || (field[i][j].isMine && !showAll))
			return ".";
		if(field[i][j].isOpen || showAll)
			if(field[i][j].isMine)
				return "X";
		if((field[i][j].isOpen || showAll) && field[i][j].numOfMines!=0)
				return String.valueOf(field[i][j].numOfMines);
		return " ";
	}
	
	// Set whether to show all fields or not
	public void setShowAll(boolean showAll) {
		this.showAll = showAll;
	}
	
	// Override toString() method to return the current state of the game
	public String toString() {
		StringBuilder minesBuilder = new StringBuilder();
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++)
				minesBuilder.append(get(i,j));
			minesBuilder.append("\n");
		}
		return minesBuilder.toString();
	}
	
	// Update the neighbor mine count for a given mine location
	private void updateNeighboursMine(int i, int j) {
		if (i - 1 >= 0 && j - 1 >= 0 && !field[i - 1][j - 1].isMine)
			field[i - 1][j - 1].setNumOfMines(field[i - 1][j - 1].numOfMines + 1);
		if (i - 1 >= 0 && !field[i - 1][j].isMine)
			field[i - 1][j].setNumOfMines(field[i - 1][j].numOfMines + 1);
		if (i - 1 >= 0 && j + 1 < width && !field[i - 1][j + 1].isMine)
			field[i - 1][j + 1].setNumOfMines(field[i - 1][j + 1].numOfMines + 1);

		if (j - 1 >= 0 && !field[i][j - 1].isMine)
			field[i][j - 1].setNumOfMines(field[i][j - 1].numOfMines + 1);
		if (j + 1 < width && !field[i][j + 1].isMine)
			field[i][j + 1].setNumOfMines(field[i][j + 1].numOfMines + 1);

		if (i + 1 < height && j - 1 >= 0 && !field[i + 1][j - 1].isMine)
			field[i + 1][j - 1].setNumOfMines(field[i + 1][j - 1].numOfMines + 1);
		if (i + 1 < height && !field[i + 1][j].isMine)
			field[i + 1][j].setNumOfMines(field[i + 1][j].numOfMines + 1);
		if (i + 1 < height && j + 1 < width && !field[i + 1][j + 1].isMine)
			field[i + 1][j + 1].setNumOfMines(field[i + 1][j + 1].numOfMines + 1);	
	}
	
	// Private inner class representing a field
	private class Field {
		private boolean isOpen, isFlag, isMine;
		private int numOfMines;
		
		public void setNumOfMines(int numOfMines) {
			this.numOfMines = numOfMines;
		}
	}
	
	// Private inner class representing a location
	private class Loaction {
		@SuppressWarnings("unused")
		private int i, j;
		
		public Loaction(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
