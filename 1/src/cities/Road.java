package cities;

public class Road {
	private City city1;
	private City city2;
	private int length;

	/* the constructor get two cities and one int variable,
	 * will use the method "connect" to connect city1 and city2 to the same road,
	 * and  also will get the distance between those two cities.
	 */
	public Road(City city1,City city2,int length)
	{
		this.city1=city1;
		this.city2=city2;
		this.length=length;
		city1.connect(this);
		city2.connect(this);
		
	}
	
	public City getCity1() {return this.city1;}
	public City getCity2() {return this.city2;}
	public int getLength() {return this.length;}



}
