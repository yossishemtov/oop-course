package shop;

public enum Type 
{
	ACOUSTIC("Acoustic"), ELECTRIC("Electric"), CLASSICAL("Classical"); // each constant have he's name
	private String name;
	 private Type(String name) // in the constructor we determine the name of each constant
	 {
		 this.name=name; 
	 }
	 
	 @Override
	 public String toString(){return name;} // the toString of constant here is the name we gave him
	 

}
