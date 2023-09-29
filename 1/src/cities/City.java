package cities;

public class City {
	private Road[] roads;
	private int numRoads;
	private String cityName;

	public City(String name) {
		this.cityName = name;
		this.roads = new Road[10];
		this.numRoads = 0;

	}

	/*
	 * Adds the road to the list of roads in a specific city.
	 */
	public void connect(Road r) {
		this.roads[numRoads] = r;
		numRoads++;
	}

	/*
	 * find the closest city to a specific city. null if there isn't one.
	 */
	public City nearestCity() {
		int dis = -1;
		int i = 0;
		int index = 0;
		if (this.roads[0] == null) {
			return null;
		}

		while (this.roads[i] != null) {

			if (dis == -1) {
				dis = this.roads[i].getLength();
				index = i;
			} else if (this.roads[i].getLength() < dis) {
				dis = this.roads[i].getLength();
				index = i;
			}
			i++;
		}
		if (this.roads[index].getCity1().toString().equals(this.toString())) {
			return this.roads[index].getCity2();
		} else {
			return this.roads[index].getCity1();

		}

	}

	public String toString() {
		return cityName;
	}
}
