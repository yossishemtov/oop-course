package cities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class World {
	private Map<String, Country> countries = new TreeMap<>(); // allocate memory for empty TreeMap

	/**
	 * Adds a new country to the world.
	 *
	 * @param name The name of the country to be added.
	 */
	public void addCountry(String name) {
		countries.put(name, new Country(name));
	}

	/**
	 * Adds a new city to the corresponding country.
	 *
	 * @param name        The name of the city to be added.
	 * @param countryName The name of the country where the city belongs.
	 * @param population  The population of the city.
	 * @throws IllegalArgumentException if the country does not exist in the world.
	 */
	public void addCity(String name, String countryName, int population) throws IllegalArgumentException {
		Country country = countries.get(countryName);
		if (country != null) {
			country.addCity(new City(name, country, population));
		} else {
			throw new IllegalArgumentException("No such country name");
		}
	}

	/**
	 * Returns the total population of all countries in the world.
	 *
	 * @return The total population.
	 */
	public int population() {
		int sum = 0;
		for (Country country : countries.values()) {
			sum += country.population();
		}
		return sum;
	}

	/**
	 * Returns a list of cities whose population is smaller than the given
	 * threshold. The list is sorted by country name, and within each country, by
	 * the name of the city.
	 *
	 * @param under The population threshold.
	 * @return The list of cities.
	 */
	public List<City> smallCities(int under) {
		List<City> smallList = new ArrayList<>();
		for (Country country : countries.values()) {
			smallList.addAll(country.smallCities(under));
		}
		return smallList;
	}

	/**
	 * Generates a report representing all the data in the world.
	 *
	 * @return The report string.
	 */
	public String report() {
		StringBuilder reportBuilder = new StringBuilder();
		for (Country country : countries.values()) {
			reportBuilder.append(country.report()).append("\n");
		}
		reportBuilder.append("Total population is ").append(population()).append("\n");
		return reportBuilder.toString();
	}
}
