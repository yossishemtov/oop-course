package cities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Country - Represents a country with a name and a collection of cities.
 */
public class Country implements Comparable<Country> {
    private String name;            // Name of the country
    private Set<City> cities;       // Set of cities in the country

    /**
     * Constructs a Country object with the specified name.
     *
     * @param name the name of the country
     */
    public Country(String name) {
        this.name = name;
        this.cities = new TreeSet<>();
    }

    /**
     * Adds a city to the country.
     *
     * @param city the city to add
     * @throws IllegalArgumentException if the country of the city does not match this country
     */
    public void addCity(City city) throws IllegalArgumentException {
        if (!this.equals(city.getCountry())) {
            throw new IllegalArgumentException("Country of the city does not match");
        }
        cities.add(city);
    }

    /**
     * Calculates the total population of all cities in the country.
     *
     * @return the total population of the country
     */
    public int population() {
        int sum = 0;
        for (City city : cities) {
            sum += city.getPopulation();
        }
        return sum;
    }

    /**
     * Returns the name of the country.
     *
     * @return the name of the country
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Retrieves a list of cities in the country with a population less than the specified value.
     *
     * @param under the maximum population threshold
     * @return a list of small cities
     */
    public List<City> smallCities(int under) {
        List<City> smallList = new ArrayList<>();
        for (City city : cities) {
            if (city.getPopulation() < under) {
                smallList.add(city);
            }
        }
        return smallList;
    }

    /**
     * Generates a report of the country's name, population, and its cities with their respective populations.
     *
     * @return the country report
     */
    public String report() {
        StringBuilder sb = new StringBuilder(String.format("%s(%d) :", name, population()));
        for (City city : cities) {
            sb.append(String.format(" %s(%d),", city.getName(), city.getPopulation()));
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * Checks if this country is equal to another object.
     * Two countries are considered equal if their names are the same.
     *
     * @param obj the object to compare with
     * @return true if the countries are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Country) {
            Country otherCountry = (Country) obj;
            return name.equals(otherCountry.toString());
        }
        return false;
    }

    /**
     * Compares this country with another country for order based on their names.
     *
     * @param otherCountry the country to compare with
     * @return a negative integer, zero, or a positive integer if this country is less than, equal to,
     *         or greater than the specified country
     */
    @Override
    public int compareTo(Country otherCountry) {
        return name.compareTo(otherCountry.toString());
    }
}
