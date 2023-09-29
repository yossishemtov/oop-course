package library;

public class Book {
	private String bookname;
	private Author a;
	
	public Book(String title,Author auth) {
		a=auth;
		bookname=title;
		
	}
	public String getTitle() {return bookname;}
	public String getAuthorName() {return a.getName();}
	public int getAuthorBirthYear() {return a.getBirthYear();}
	
	/*toString - return the title of the book that written by the given author*/
	public String toString() {
		return String.format("%s written by %s",bookname, a.toString());

	}
}