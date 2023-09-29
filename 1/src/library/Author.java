package library;



public class Author {
	private String name;
	private int birthYear;
	
	
	public Author(String name,int birthYear) {
		this.name=name;
		this.birthYear=birthYear;
		
		
	}
	public String getName() {return name;}
	public int getBirthYear() {return birthYear;}
	
	/*getAge - calculates the age of the Author by the birthYear value.*/
	public int getAge(int thisYear) {return thisYear-birthYear;}
	
	public String toString() {
		return String.format("%s(%d)", name, birthYear);
	}
	

	
	

}
