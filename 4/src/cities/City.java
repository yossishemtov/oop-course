package cities;

/**
 * City - Represents a city with a name, country, and population.
 */
public class City implements Comparable<City> {
    private String name;        // Name of the city
    private Country country;    // Country instance associated with the city
    private int population;     // Population of the city

    /**
     * Constructs a City object with the specified name, country, and population.
     *
     * @param name       the name of the city
     * @param country    the country associated with the city
     * @param population the population of the city
     */
    public City(String name, Country country, int population) {
        this.country = country;
        this.name = name;
        this.population = population;
    }

    /**
     * Retrieves the name of the city.
     *
     * @return the name of the city
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the country associated with the city.
     *
     * @return the country associated with the city
     */
    public Country getCountry() {
        return country;
    }

    /**
     * Retrieves the population of the city.
     *
     * @return the population of the city
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Returns a string representation of the city in the format "CityName (of CountryName)".
     *
     * @return a string representation of the city
     */
    @Override
    public String toString() {
        return String.format("%s (of %s)", name, country);
    }

    /**
     * Checks if this city is equal to another object.
     * Two cities are considered equal if their countries and names are the same.
     *
     * @param obj the object to compare with
     * @return true if the cities are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof City) {
            City otherCity = (City) obj;
            return country.equals(otherCity.getCountry()) && name.equals(otherCity.getName());
        }
        return false;
    }

    /**
     * Compares this city with another city for order.
     * Cities are first compared based on their countries in ascending order.
     * If the countries are the same, cities are then compared based on their names in ascending order.
     *
     * @param otherCity the city to compare with
     * @return a negative integer, zero, or a positive integer if this city is less than, equal to,
     *         or greater than the specified city
     */
    @Override
    public int compareTo(City otherCity) {
        int countryComparison = country.compareTo(otherCity.getCountry());
        if (countryComparison == 0) {
            return name.compareTo(otherCity.getName());
        } else {
            return countryComparison;
        }
    }
}
