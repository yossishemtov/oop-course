package shop;

public class Guitar extends Instrument {
    Type guitarType;

    /**
     * Constructs a Guitar object with the specified company, price, and type.
     *
     * @param company The company name of the guitar.
     * @param price   The price of the guitar.
     * @param type    The type of the guitar.
     */
    public Guitar(String company, int price, Type type) {
        super(company, price); // use super constructor
        this.guitarType = type; // save the type of the guitar
    }

    /**
     * Returns the type of the guitar.
     *
     * @return The type of the guitar.
     */
    public Type getType() {
        return guitarType;
    }

    @Override
    public String toString() {
        return String.format("Guitar(%s) %s(%d), price = %d", guitarType, getCompany(), getSerial(), getPrice());
    }
}
