package shop;

public abstract class Instrument {
    private static int instrumentCount = 0; // static variable to determine the serial of the instrument
    private String instrumentCompany; // company, instrumentPrice, instrumentSerial can be in the abstract to avoid code repetition
    private int instrumentPrice, instrumentSerial;
	
    /**
     * Constructs an Instrument object with the specified company and price.
     */
    public Instrument(String company, int price) {
        this.instrumentCompany = company;
        this.instrumentPrice = price;
        this.instrumentSerial = instrumentCount; // give this instrument its serial
        instrumentCount++; // advance serial
    }
	
    /**
     * Returns the price of the instrument.
     */
    public final int getPrice() {
        return instrumentPrice;
    }

    /**
     * Returns the company name of the instrument.
     *
     * @return The company name of the instrument.
     */
    public final String getCompany() {
        return instrumentCompany;
    }

    /**
     * Returns the serial number of the instrument.
     *
     * @return The serial number of the instrument.
     */
    public final int getSerial() {
        return instrumentSerial;
    }
}
