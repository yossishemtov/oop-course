package library;

public class Library {
	private Book[] books;

	public Library(int size) {
		this.books = new Book[size];

	}

	/*
	 create a book in the library. (in bookNum index)
	 */
	public void setBook(int bookNum, String title, Author auth) {
		this.books[bookNum] = new Book(title, auth);

	}

	/*
	 return the book in the bookNum index in the libary. if the book doesn't exist return null
	 */
	public Book getBook(int bookNum) {
		if (books[bookNum] != null)
			return books[bookNum];
		else
			return null;

	}

}
